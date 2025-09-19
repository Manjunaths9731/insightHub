package com.example.data_collector_service.repository;

import com.example.data_collector_service.entity.IngestionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngestionLogRepository extends JpaRepository<IngestionLog, Long> {
    List<IngestionLog> findBySource(String source);
}
