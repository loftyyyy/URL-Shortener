package com.rho.urlshortener.encoder;

import org.springframework.stereotype.Component;

@Component
public class Base62Encoder {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = ALPHABET.length();

    public String encode(long id){

        return "";
    }

    public String decode(long id){

        return "";
    }
}
