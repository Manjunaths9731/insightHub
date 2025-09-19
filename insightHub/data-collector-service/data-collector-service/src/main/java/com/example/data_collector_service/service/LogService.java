package com.example.data_collector_service.service;

import com.example.data_collector_service.entity.IngestionLog;
import com.example.data_collector_service.repository.IngestionLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogService {
    private final IngestionLogRepository ingestionLogRepository;

    public List<IngestionLog> getAllLogs() {
        return ingestionLogRepository.findAll();
    }

    public Optional<IngestionLog> getLogById(Long id) {
        return ingestionLogRepository.findById(id);
    }

    public List<IngestionLog> getLogsBySource(String source) {
        return ingestionLogRepository.findBySource(source);
    }
}
