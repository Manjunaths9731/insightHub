package com.example.data_collector_service.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
@Slf4j
@EnableKafka
public class KafkaErrorHandlerConfig {

    @Bean
    public DefaultErrorHandler errorHandler() {
        FixedBackOff fixedBackOff = new FixedBackOff(2000L, 3);

        return new DefaultErrorHandler((record, ex) -> {
            log.error("Failed to Consume and Save into DB {}", record.value());
        }, fixedBackOff);
    }
}
