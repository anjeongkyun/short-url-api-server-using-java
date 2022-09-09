package com.ab180.airbridge.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ShortUrlResponseDto {
    private ReponseData data;

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class ReponseData{
        private String shortId;
        private String url;
        private LocalDateTime createdAt;
    }
}
