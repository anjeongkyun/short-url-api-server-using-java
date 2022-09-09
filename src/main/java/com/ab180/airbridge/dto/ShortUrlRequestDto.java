package com.ab180.airbridge.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ShortUrlRequestDto {

    private String url;
}
