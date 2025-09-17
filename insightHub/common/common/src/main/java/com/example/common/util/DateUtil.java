package com.example.common.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("IST"));

    private static String format(Instant instant) {
        return FORMATTER.format(instant);
    }

    public static Instant now() {
        return Instant.now();
    }
}
