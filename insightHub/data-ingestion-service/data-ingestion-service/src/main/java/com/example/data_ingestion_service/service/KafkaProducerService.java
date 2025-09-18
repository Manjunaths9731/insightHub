package com.example.data_ingestion_service.service;

import com.example.common.dto.EventMessage;
import com.example.common.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, EventMessage event) {
        String payload = JsonUtil.toJson(event);
        kafkaTemplate.send(topic, payload);
    }
}
