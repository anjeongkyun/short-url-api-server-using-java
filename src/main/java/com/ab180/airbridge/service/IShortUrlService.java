package com.ab180.airbridge.service;

import com.ab180.airbridge.dto.ShortUrlRequestDto;
import org.springframework.http.ResponseEntity;

import java.security.NoSuchAlgorithmException;

public interface IShortUrlService {
    ResponseEntity<?> convertShortUrl(ShortUrlRequestDto shortUrlRequestDto);
    ResponseEntity<?> urlRedirect(String shortId);
}
