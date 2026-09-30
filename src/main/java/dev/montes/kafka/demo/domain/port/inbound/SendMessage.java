package dev.montes.kafka.demo.domain.port.inbound;

public interface SendMessage {
  void send(String content);
}
