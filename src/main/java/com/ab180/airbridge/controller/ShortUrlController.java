package com.ab180.airbridge.controller;

import com.ab180.airbridge.dto.ShortUrlRequestDto;
import com.ab180.airbridge.exception.CustomException;
import com.ab180.airbridge.service.IShortUrlService;
import com.ab180.airbridge.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import static com.ab180.airbridge.exception.ErrorCode.*;

@RequiredArgsConstructor
@RequestMapping("/short-links")
@RestController
public class ShortUrlController {

    private final IShortUrlService iShortLinkService;

    @PostMapping
    private ResponseEntity<?> convertShortLink(
            @RequestBody ShortUrlRequestDto shortUrlRequestDto,
            Errors errors
    ) {
        String url = shortUrlRequestDto.getUrl();

        if(ObjectUtils.isEmpty(url))
            throw new CustomException(URL_IFNO_NOT_VALUE);

        if(!CommonUtils.urlValidationCheck(url))
            throw new CustomException(URL_INFO_WRONG_FORMAT);


        return iShortLinkService.convertShortUrl(shortUrlRequestDto);

    }

    @GetMapping("/{short_id}")
    private ResponseEntity<?> getShortLink(
            @PathVariable String short_id
    ) {

        if(ObjectUtils.isEmpty(short_id))
            throw new CustomException(SHORT_ID_NOT_VALUE);

        return iShortLinkService.urlRedirect(short_id);
    }
}
