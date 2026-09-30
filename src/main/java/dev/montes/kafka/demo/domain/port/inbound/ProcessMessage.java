package dev.montes.kafka.demo.domain.port.inbound;

import dev.montes.kafka.demo.domain.model.Message;

public interface ProcessMessage {

  void process(Message message);

}
