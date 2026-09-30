package dev.montes.kafka.demo.infrastructure.adapter.inbound.kafka;

import java.time.LocalDateTime;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import dev.montes.kafka.demo.domain.model.Message;
import dev.montes.kafka.demo.domain.port.inbound.ProcessMessage;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class KafkaConsumerAdapter {

  private final ProcessMessage processMessage;

  @KafkaListener(topics = "demo-topic", groupId = "demo-group")
  public void listen(String rawPayload) {
    String[] parts = rawPayload.split("\\|");
    Message message = new Message(parts[0], parts[1], LocalDateTime.parse(parts[2]));
    processMessage.process(message);
  }
}
