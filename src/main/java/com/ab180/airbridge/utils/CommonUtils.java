package com.ab180.airbridge.utils;

import org.springframework.stereotype.Component;
import org.apache.commons.validator.routines.UrlValidator;

import java.time.Instant;
import java.util.UUID;

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

    public static String generateRandomValue(){
        int min = 10000;
        int max = 99999;
        int random  = (int) ((Math.random()) * (max - min) + min);
        return String.valueOf(random);
    }
}
