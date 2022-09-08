package com.ab180.airbridge.controller;

import com.ab180.airbridge.dto.ShortUrlRequestDto;
import com.ab180.airbridge.service.IShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/short-links")
@RestController
public class ShortUrlController {

    private final IShortUrlService iShortLinkService;

    @PostMapping
    private ResponseEntity<?> convertShortLink(
            @RequestBody ShortUrlRequestDto shortUrlRequestDto
    ) {

        return iShortLinkService.convertShortUrl(shortUrlRequestDto);
    }

    @GetMapping("/{short_id}")
    private String getShortLink(
            @PathVariable String short_id
    ) {

        return "test";
    }
}
