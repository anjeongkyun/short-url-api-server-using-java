package com.ab180.airbridge.utils;

import org.springframework.stereotype.Component;
import org.apache.commons.validator.routines.UrlValidator;

@Component
public class CommonUtils {
    public boolean urlValidationCheck(String urlStr){
        return new UrlValidator().isValid(urlStr);
    }

    public static boolean urlValidator(String url)
    {
        UrlValidator defaultValidator = new UrlValidator();
        return defaultValidator.isValid(url);
    }
}
