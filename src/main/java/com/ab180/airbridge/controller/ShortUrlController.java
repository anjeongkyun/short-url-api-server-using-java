package com.ab180.airbridge.controller;

import com.ab180.airbridge.dto.ShortUrlRequestDto;
import com.ab180.airbridge.service.IShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RequiredArgsConstructor
@RequestMapping("/short-links")
@RestController
public class ShortUrlController {

    private final IShortUrlService iShortLinkService;

    @PostMapping
    private ResponseEntity<?> convertShortLink(
            @RequestBody @Valid ShortUrlRequestDto shortUrlRequestDto,
            Errors errors
    ) {

        if(errors.hasErrors()) {
            String errMsg = Objects.requireNonNull(errors.getFieldError()).getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errMsg);
        }

        return iShortLinkService.convertShortUrl(shortUrlRequestDto);

    }

    @GetMapping("/{short_id}")
    private ResponseEntity<?> getShortLink(
            @PathVariable String short_id
    ) {

        return iShortLinkService.urlRedirect(short_id);
    }
}
