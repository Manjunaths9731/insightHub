package com.example.common.dto;

import com.example.common.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventMessage {
    private String id = UUID.randomUUID().toString();
    private String type;
    private String source;
    private Object payload;
    private LocalDateTime timestamp = DateUtil.now();
}
