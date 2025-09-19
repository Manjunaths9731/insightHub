package com.example.data_collector_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ingestion_log")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngestionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String source;

    @Column(columnDefinition = "TEXT")
    private String payload;

    private LocalDateTime receivedAt;
}
