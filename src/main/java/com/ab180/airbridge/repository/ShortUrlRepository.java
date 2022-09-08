package com.ab180.airbridge.repository;

import com.ab180.airbridge.domain.ShortUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {
    ShortUrlEntity findFirstByShortUrlOrOriginUrl(String shortUrl, String originUrl);
    boolean existsByShortUrlOrOriginUrl(String shortUrl, String originUrl);

}
