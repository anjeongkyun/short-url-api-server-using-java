package com.ab180.airbridge.utils;

import org.springframework.stereotype.Component;

@Component
public class UrlEncoderUtils {
    private final int BASE62 = 62;
    private final String BASE62_VALUE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private String encoding(long param) {
        StringBuffer sb = new StringBuffer();
        while(param > 0) {
            sb.append(BASE62_VALUE.charAt((int) (param % BASE62)));
            param /= BASE62;
        }
        return sb.toString();
    }

    public String urlEncoder(long shortId){
        long encodeVal = generateEncodeVal(shortId);
        String encodeStr = encoding(encodeVal);

        return encodeStr;
    }

    private long generateEncodeVal(long shortId){
        String shortIdToStr = String.valueOf(shortId);
        if(shortIdToStr.length() == 1){
            shortId = shortId * 10000;
        }else if(shortIdToStr.length() == 2) {
            shortId = shortId * 1000;
        }

        return shortId;
    }

}
