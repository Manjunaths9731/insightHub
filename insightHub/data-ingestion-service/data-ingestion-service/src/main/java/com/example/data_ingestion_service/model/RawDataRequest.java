package com.example.data_ingestion_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawDataRequest {
    private String source;
    private String entityType;
    private Object payload;
}
