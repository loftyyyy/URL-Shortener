package com.rho.urlshortener.controller;


import com.rho.urlshortener.dto.UrlRequestDTO;
import com.rho.urlshortener.dto.UrlResponseDTO;
import com.rho.urlshortener.service.UrlShortenerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController ("/api")
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    public UrlShortenerController(UrlShortenerService urlShortenerService){
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<?> shortenUrl(@Valid @RequestBody UrlRequestDTO urlRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(urlShortenerService.shortenUrl(urlRequestDTO));
    }

    @GetMapping("/{shortKey}")
    public ResponseEntity<?> redirectToLongUrl(@PathVariable String shortKey){
        String url = urlShortenerService.getLongUrl(shortKey);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url));

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }



}
