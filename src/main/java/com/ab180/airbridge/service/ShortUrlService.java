package com.ab180.airbridge.service;

import com.ab180.airbridge.domain.ShortUrlEntity;
import com.ab180.airbridge.dto.ShortUrlRequestDto;
import com.ab180.airbridge.dto.ShortUrlResponseDto;
import com.ab180.airbridge.repository.ShortUrlRepository;
import com.ab180.airbridge.utils.UrlEncoderUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;

import static com.ab180.airbridge.utils.CommonUtils.generateRandomValue;

@AllArgsConstructor
@Service
public class ShortUrlService implements IShortUrlService {
    private final UrlEncoderUtils urlEncoderUtils;
    private final ShortUrlRepository shortUrlRepository;

    @Transactional
    @Override
    public ResponseEntity<?> convertShortUrl(ShortUrlRequestDto shortUrlRequestDto){
        String encodeUrl;
        String url = shortUrlRequestDto.getUrl();
        ShortUrlEntity shortUrlEntity = shortUrlRepository.findByOriginUrl(url);

        if(ObjectUtils.isEmpty(shortUrlEntity)){
            ShortUrlEntity shortUrl = shortUrlRepository.findTop1ByOrderByCreatedAtDesc();
            encodeUrl = urlEncoderUtils.urlEncoder(shortUrl.getUrlId());

            shortUrl = ShortUrlEntity
                    .builder()
                    .shortId(encodeUrl)
                    .originUrl(url)
                    .build();

            shortUrl = shortUrlRepository.save(shortUrl);
            ShortUrlResponseDto shortUrlResponseDto = shortUrlEntityToDto(shortUrl);
            return ResponseEntity.ok(shortUrlResponseDto);
        }else{
            ShortUrlResponseDto shortUrlResponseDto = shortUrlEntityToDto(shortUrlEntity);

            return ResponseEntity.ok(shortUrlResponseDto);
        }
    }

    @Override
    public ResponseEntity<?> urlRedirect(String shortId) {
        ShortUrlEntity shortUrlEntity = shortUrlRepository.findByShortId(shortId);
        ShortUrlResponseDto shortUrlResponseDto = shortUrlEntityToDto(shortUrlEntity);

        return ResponseEntity.status(HttpStatus.FOUND).body(shortUrlResponseDto);
    }

    private ShortUrlResponseDto shortUrlEntityToDto(ShortUrlEntity shortUrlEntity){
        ShortUrlResponseDto shortUrlResponseDto
                = ShortUrlResponseDto
                .builder()
                .data(
                        ShortUrlResponseDto.ReponseData
                                .builder()
                                .shortId(shortUrlEntity.getShortId())
                                .url(shortUrlEntity.getOriginUrl())
                                .createdAt(shortUrlEntity.getCreatedAt())
                                .build()
                )
                .build();
        return shortUrlResponseDto;
    }
}
