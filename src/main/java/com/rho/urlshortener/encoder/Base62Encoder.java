package com.rho.urlshortener.encoder;

import org.springframework.stereotype.Component;

@Component
public class Base62Encoder {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = ALPHABET.length();

    public String encode(long id){
        if(id == 0){
            return String.valueOf(ALPHABET.charAt(0));
        }

        StringBuilder sb = new StringBuilder();
        while(id > 0){
            int remainder = (int) (id % BASE);
            sb.append(ALPHABET.charAt(remainder));
            id /= BASE;
        }

        return sb.reverse().toString();
    }

    public long decode(String shortKey){
        long id = 0;

        for(int i = 0; i < shortKey.length(); i++){
            id = (id * BASE) + ALPHABET.indexOf(shortKey.charAt(i));
        }

        return id;
    }
}
