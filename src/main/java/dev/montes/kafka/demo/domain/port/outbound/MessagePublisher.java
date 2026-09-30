package dev.montes.kafka.demo.domain.port.outbound;

import dev.montes.kafka.demo.domain.model.Message;

public interface MessagePublisher {

  void publish(Message message);

}
