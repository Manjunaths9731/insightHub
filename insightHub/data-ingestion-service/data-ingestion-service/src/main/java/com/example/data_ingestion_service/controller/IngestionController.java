package com.example.data_ingestion_service.controller;

import com.example.common.dto.BaseResponse;
import com.example.data_ingestion_service.model.RawDataRequest;
import com.example.data_ingestion_service.service.IngestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ingest")
@RequiredArgsConstructor
public class IngestionController {
    private final IngestionService ingestionService;

    @PostMapping()
    public BaseResponse<String> ingestApi(@RequestBody RawDataRequest request) {
        return ingestionService.ingest(request);
    }
}
