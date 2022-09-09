package com.ab180.airbridge.repository;

import com.ab180.airbridge.domain.ShortUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {
    ShortUrlEntity findTop1ByOrderByCreatedAtDesc();
    ShortUrlEntity findByOriginUrl(String OriginUrl);
    ShortUrlEntity findByShortId(String shortId);
}
