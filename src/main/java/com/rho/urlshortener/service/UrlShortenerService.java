package com.rho.urlshortener.service;

import com.rho.urlshortener.encoder.Base62Encoder;
import com.rho.urlshortener.model.UrlEntity;
import com.rho.urlshortener.repository.UrlShortenerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlShortenerService {

    private final UrlShortenerRepository urlShortenerRepository;
    private final Base62Encoder base62Encoder;

    public UrlShortenerService(UrlShortenerRepository shortenerRepository, Base62Encoder base62Encoder){
        this.urlShortenerRepository = shortenerRepository;
        this.base62Encoder = base62Encoder;
    }

    @Transactional
    public String shortenUrl(String longUrl){
        UrlEntity urlEntity = UrlEntity.builder()
                .shortKey("TEMP")
                .longUrl(longUrl)
                .build();

        urlEntity = urlShortenerRepository.save(urlEntity);
        String shortKey = base62Encoder.encode(urlEntity.getId());
        urlEntity.setShortKey(shortKey);
        urlShortenerRepository.save(urlEntity);


        return shortKey;
    }

}
