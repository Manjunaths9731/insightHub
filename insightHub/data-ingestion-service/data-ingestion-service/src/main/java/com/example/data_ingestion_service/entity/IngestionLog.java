package com.example.data_ingestion_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(name = "ingestionLog")
public class IngestionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String source;
    private String entityType;

    @Column(columnDefinition = "TEXT")
    private String payload;

    private boolean success;
    private Instant createdAt = Instant.now();
}
