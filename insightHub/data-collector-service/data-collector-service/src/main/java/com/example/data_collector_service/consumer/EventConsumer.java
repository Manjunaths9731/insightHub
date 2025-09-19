package com.example.data_collector_service.consumer;

import com.example.common.dto.EventMessage;
import com.example.common.util.DateUtil;
import com.example.common.util.JsonUtil;
import com.example.data_collector_service.entity.IngestionLog;
import com.example.data_collector_service.repository.IngestionLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventConsumer {
    private final IngestionLogRepository ingestionLogRepository;

    @KafkaListener(topics = "ingestion_events", groupId = "data_collector_group")
    public void consume(String message) {
        try {
            EventMessage eventMessage = JsonUtil.fromJson(message, EventMessage.class);
            System.out.println("Received Event :" + eventMessage);

            IngestionLog ingestionLog = IngestionLog.builder()
                    .source(eventMessage.getSource())
                    .payload(JsonUtil.toJson(eventMessage.getPayload()))
                    .receivedAt(DateUtil.now())
                    .build();

            ingestionLogRepository.save(ingestionLog);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to save : " + e.getMessage(), e);
        }
    }
}
