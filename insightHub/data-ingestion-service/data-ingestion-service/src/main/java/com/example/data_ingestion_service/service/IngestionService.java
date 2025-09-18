package com.example.data_ingestion_service.service;

import com.example.common.constants.AppConstants;
import com.example.common.dto.BaseResponse;
import com.example.common.dto.EventMessage;
import com.example.data_ingestion_service.entity.IngestionLog;
import com.example.data_ingestion_service.model.RawDataRequest;
import com.example.data_ingestion_service.repository.IngestionLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngestionService {
    private final KafkaProducerService kafkaProducerService;
    private final IngestionLogRepository ingestionLogRepository;

    public BaseResponse<String> ingest(RawDataRequest request) {
        IngestionLog log = new IngestionLog();
        log.setSource(request.getSource());
        log.setPayload(request.getPayload());
        log.setEntityType(request.getEntityType());

        try {
            EventMessage event = new EventMessage();
            event.setType(request.getEntityType());
            event.setPayload(request.getPayload());

            kafkaProducerService.send(AppConstants.KAFKA_TOPIC_EVENTS, event);

            log.setSuccess(true);
            ingestionLogRepository.save(log);

            return new BaseResponse<>(true, "Data ingested successfully", event.getId());
        } catch (Exception e) {
            log.setSuccess(false);
            ingestionLogRepository.save(log);
            return new BaseResponse<>(false, "Data ingestion failed: " + e.getMessage(), null);
        }
    }
}
