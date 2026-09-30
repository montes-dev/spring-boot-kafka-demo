package dev.montes.kafka.demo.infrastructure.adapter.outbound.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import dev.montes.kafka.demo.domain.model.Message;
import dev.montes.kafka.demo.domain.port.outbound.MessagePublisher;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class KafkaProducerAdapter implements MessagePublisher {

  private final KafkaTemplate<String, String> kafkaTemplate;
  private static final String TOPIC = "demo-topic";

  @Override
  public void publish(Message message) {
    String payload = message.id() + "|" + message.content() + "|" + message.timestamp();
    System.out.println("📤 [INFRAESTRUCTURA/KAFKA] Publicando evento: " + payload);
    kafkaTemplate.send(TOPIC, message.id(), payload);
  }
}
