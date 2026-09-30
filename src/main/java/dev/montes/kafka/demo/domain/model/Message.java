package dev.montes.kafka.demo.domain.model;

import java.time.LocalDateTime;

public record Message(String id, String content, LocalDateTime timestamp) {
}
