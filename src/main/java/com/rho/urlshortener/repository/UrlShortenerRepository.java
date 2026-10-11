package com.rho.urlshortener.repository;

import com.rho.urlshortener.model.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlShortenerRepository extends JpaRepository<UrlEntity, Long> {

    Optional<UrlEntity> findByShortKey(String shortKey);
}
