package com.ab180.airbridge.dto;

import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ShortUrlRequestDto {

    @URL(message = "잘못된 URL 형식입니다.")
    @NotEmpty(message = "URL값이 비어있으면 안됩니다.")
    private String url;
}
