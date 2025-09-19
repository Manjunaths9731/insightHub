package com.example.data_collector_service.controller;

import com.example.data_collector_service.entity.IngestionLog;
import com.example.data_collector_service.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/logs")
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;

    @GetMapping
    public ResponseEntity<List<IngestionLog>> getAllLogs() {
        return ResponseEntity.ok(logService.getAllLogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngestionLog> getLogsById(@PathVariable Long id) {
        return logService.getLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/source/{source}")
    public ResponseEntity<List<IngestionLog>> getLogsBySource(@PathVariable String source) {
        return ResponseEntity.ok(logService.getLogsBySource(source));
    }
}
