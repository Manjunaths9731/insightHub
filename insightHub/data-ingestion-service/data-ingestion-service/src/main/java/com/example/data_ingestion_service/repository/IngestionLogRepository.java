package com.example.data_ingestion_service.repository;

import com.example.data_ingestion_service.entity.IngestionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngestionLogRepository extends JpaRepository<IngestionLog, Long> {
}
