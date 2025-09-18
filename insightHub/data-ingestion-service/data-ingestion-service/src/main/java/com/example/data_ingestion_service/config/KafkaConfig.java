package com.example.data_ingestion_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic eventsTopic() {
        return new NewTopic("events_topic", 3, (short) 1);
    }
}
