package com.ab180.airbridge.utils;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
    public static boolean urlValidationCheck(String urlStr){
        return new UrlValidator().isValid(urlStr);
    }
}
