package com.example.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventMessage {
    private String id = UUID.randomUUID().toString();
    private String type;
    private Object payload;
    private Instant timestamp = Instant.now();
}
