package com.rho.urlshortener.dto;


import jakarta.validation.constraints.NotBlank;

public record UrlRequestDTO(@NotBlank String url) {
}
