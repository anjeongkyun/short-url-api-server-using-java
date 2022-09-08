package com.ab180.airbridge.utils;

import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

@Component
public class UrlEncoderUtils {
    private final String URL_PREFIX = "http://test.com/";
    private final int BASE64 = 64;
    private final String BASE64_VALUE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private String encoding(long param) {
        StringBuffer sb = new StringBuffer();
        while(param > 0) {
            sb.append(BASE64_VALUE.charAt((int) (param % BASE64)));
            param /= BASE64;
        }
        return URL_PREFIX + sb.toString();
    }

    private long decode(String param) {
        long sum = 0;
        long power = 1;
        for (int i = 0; i < param.length(); i++) {
            sum += BASE64_VALUE.indexOf(param.charAt(i)) * power;
            power *= BASE64;
        }
        return sum;
    }

    public String urlEncoder(String seqStr) throws NoSuchAlgorithmException {
        String encodeStr = encoding(Integer.valueOf(seqStr));
        return encodeStr;
    }


    public long urlDecoder(String encodeStr) throws NoSuchAlgorithmException {
        if(encodeStr.trim().startsWith(URL_PREFIX)){
            encodeStr = encodeStr.replace(URL_PREFIX, "");
        }
        long decodeVal = decode(encodeStr);
        return decodeVal;
    }

}
