package dev.montes.kafka.demo.infrastructure.adapter.inbound.scheduler;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import dev.montes.kafka.demo.domain.port.inbound.SendMessage;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ScheduledPublisherAdapter {

  private final SendMessage sendMessage;
  private final AtomicInteger counter = new AtomicInteger(1);

  @Scheduled(fixedRate = 3000)
  public void execute() {
    sendMessage.send("Mensaje de prueba #" + counter.getAndIncrement());
  }
}
