package com.rho.urlshortener.repository;

import com.rho.urlshortener.model.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlShortenerRepository extends JpaRepository<UrlEntity, Long> {

}
