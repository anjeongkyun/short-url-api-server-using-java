package com.ab180.airbridge.service;

import com.ab180.airbridge.domain.ShortUrlEntity;
import com.ab180.airbridge.dto.ShortUrlRequestDto;
import com.ab180.airbridge.repository.ShortUrlRepository;
import com.ab180.airbridge.utils.CommonUtils;
import com.ab180.airbridge.utils.UrlEncoderUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@AllArgsConstructor
@Service
public class ShortUrlService implements IShortUrlService {
    private final CommonUtils commonUtils;
    private final UrlEncoderUtils urlEncoderUtils;
    private final ShortUrlRepository shortUrlRepository;

    @Override
    public ResponseEntity<?> convertShortUrl(ShortUrlRequestDto shortUrlRequestDto){
        String url = shortUrlRequestDto.getUrl();

        if(ObjectUtils.isEmpty(url))
            return ResponseEntity.badRequest().body("url이 비어있습니다.");

        if(!commonUtils.urlValidator(url)){
            return ResponseEntity.badRequest().body("url 형식이 아닙니다.");
        }

        if(urlExists(url)){
            ShortUrlEntity shortUrlEntity = shortUrlRepository.findFirstByShortUrlOrOriginUrl(url, url);
            System.out.println(shortUrlEntity);
        }else{

        }

        return null;
    }

    @Override
    public boolean urlExists(String url){
        return shortUrlRepository.existsByShortUrlOrOriginUrl(url, url);
    }

}
