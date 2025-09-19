package com.example.data_ingestion_service.service;

import com.example.common.constants.AppConstants;
import com.example.common.dto.BaseResponse;
import com.example.common.dto.EventMessage;
import com.example.common.util.JsonUtil;
import com.example.data_ingestion_service.model.RawDataRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngestionService {
    private final KafkaProducerService kafkaProducerService;

    public BaseResponse<String> ingest(RawDataRequest request) {
        try {
            EventMessage event = new EventMessage();
            event.setType(request.getEntityType());
            event.setSource(request.getSource());
            event.setPayload(JsonUtil.toJson(request.getPayload()));
            kafkaProducerService.send(AppConstants.KAFKA_INGEST_TOPIC, event);

            return new BaseResponse<>(true, "Data ingested successfully", event.getId());
        } catch (Exception e) {
            return new BaseResponse<>(false, "Data ingestion failed: " + e.getMessage(), null);
        }
    }
}
