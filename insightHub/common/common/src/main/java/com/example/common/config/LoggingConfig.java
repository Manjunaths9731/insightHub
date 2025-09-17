package com.example.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {
    private static final Logger log = LoggerFactory.getLogger(LoggingConfig.class);

    public LoggingConfig() {
        log.info("Common Logging Config initialized");
    }
}
