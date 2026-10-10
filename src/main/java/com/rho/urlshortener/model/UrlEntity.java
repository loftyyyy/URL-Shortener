package com.rho.urlshortener.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;



@Entity
@Table(name = "urls", indexes = {
        @Index(name = "idx_short_key", columnList = "shortKey", unique = true)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Numeric ID used for Base62 encoding

    @Column(nullable = false, unique = true, length = 10)
    private String shortKey; // The Base62 string (e.g., "Ab3XyZ")

    @Column(nullable = false, columnDefinition = "TEXT")
    private String longUrl; // The original destination URL

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
