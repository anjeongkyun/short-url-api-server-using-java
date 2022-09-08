package com.ab180.airbridge.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ShortUrlResponseDto {
    private ReponseData data;

    public class ReponseData{
        private String shortId;
        private String url;
        private String createdAt;
    }
}
