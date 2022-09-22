package com.ab180.airbridge.service.impl;

import com.ab180.airbridge.dao.ShortUrlDao;
import com.ab180.airbridge.domain.ShortUrlEntity;
import com.ab180.airbridge.dto.ShortUrlRequestDto;
import com.ab180.airbridge.dto.ShortUrlResponseDto;
import com.ab180.airbridge.repository.ShortUrlRepository;
import com.ab180.airbridge.service.IShortUrlService;
import com.ab180.airbridge.utils.UrlEncoderUtils;
import com.ab180.airbridge.exception.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import javax.transaction.Transactional;

import static com.ab180.airbridge.exception.ErrorCode.SHORT_LINK_NOT_FOUND;

@AllArgsConstructor
@Service
public class ShortUrlServiceImpl implements IShortUrlService {
    private final UrlEncoderUtils urlEncoderUtils;
    private final ShortUrlDao shortUrlDao;

    @Transactional
    @Override
    public ResponseEntity<?> convertShortUrl(ShortUrlRequestDto shortUrlRequestDto){
        String encodeUrl;
        String url = shortUrlRequestDto.getUrl();
        ShortUrlEntity shortUrlEntity = shortUrlDao.findByOriginUrl(url);

        if(ObjectUtils.isEmpty(shortUrlEntity)){
            ShortUrlEntity shortUrl = shortUrlDao.findTop1ByOrderByCreatedAtDesc();

            if(shortUrl == null){
                shortUrl = ShortUrlEntity
                        .builder()
                        .originUrl(url)
                        .build();

                shortUrl = shortUrlDao.shortUrlSave(shortUrl);
                shortUrlDao.deleteAllByUrlId(shortUrl.getUrlId());
            }

            encodeUrl = urlEncoderUtils.urlEncoder(shortUrl.getUrlId());

            shortUrl = ShortUrlEntity
                    .builder()
                    .shortId(encodeUrl)
                    .originUrl(url)
                    .build();

            shortUrl = shortUrlDao.shortUrlSave(shortUrl);
            ShortUrlResponseDto shortUrlResponseDto = shortUrlEntityToDto(shortUrl);
            return ResponseEntity.ok(shortUrlResponseDto);
        }else{
            ShortUrlResponseDto shortUrlResponseDto = shortUrlEntityToDto(shortUrlEntity);

            return ResponseEntity.ok(shortUrlResponseDto);
        }
    }

    @Override
    public ResponseEntity<?> urlRedirect(String shortId) {

        ShortUrlEntity shortUrlEntity = shortUrlDao.findByShortId(shortId);
        if(ObjectUtils.isEmpty(shortUrlEntity))
            throw new CustomException(SHORT_LINK_NOT_FOUND);

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
