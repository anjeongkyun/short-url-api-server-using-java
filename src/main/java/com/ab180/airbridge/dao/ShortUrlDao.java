package com.ab180.airbridge.dao;

import com.ab180.airbridge.domain.ShortUrlEntity;
import com.ab180.airbridge.repository.ShortUrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ShortUrlDao {

    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlEntity findByOriginUrl(String url) {
        return shortUrlRepository.findByOriginUrl(url);
    }

    public ShortUrlEntity findTop1ByOrderByCreatedAtDesc() {
        return shortUrlRepository.findTop1ByOrderByCreatedAtDesc();
    }

    public ShortUrlEntity shortUrlSave(ShortUrlEntity shortUrl){
        return shortUrlRepository.save(shortUrl);
    }

    public void deleteAllByUrlId(long urlId) {
        shortUrlRepository.deleteAllByUrlId(urlId);
    }

    public ShortUrlEntity findByShortId(String shortId) {
        return shortUrlRepository.findByShortId(shortId);
    }
}
