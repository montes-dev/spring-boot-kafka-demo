package dev.montes.kafka.demo.domain.application.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.montes.kafka.demo.domain.model.Message;
import dev.montes.kafka.demo.domain.port.inbound.ProcessMessage;
import dev.montes.kafka.demo.domain.port.inbound.SendMessage;
import dev.montes.kafka.demo.domain.port.outbound.MessagePublisher;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageService implements SendMessage, ProcessMessage {

  private final MessagePublisher publisher;

  @Override
  public void process(Message message) {
    System.out.println("📥 [DOMINIO] Procesando mensaje recibido: " + message);
  }

  @Override
  public void send(String content) {
    Message message = new Message(UUID.randomUUID().toString(), content, LocalDateTime.now());
    publisher.publish(message);
  }
}
