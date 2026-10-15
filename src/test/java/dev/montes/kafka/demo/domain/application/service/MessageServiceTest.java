package dev.montes.kafka.demo.domain.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.montes.kafka.demo.domain.model.Message;
import dev.montes.kafka.demo.domain.port.outbound.MessagePublisher;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

  @Mock
  private MessagePublisher publisher;

  @InjectMocks
  private MessageService messageService;

  @Test
  void sendPublishesMessageWithContentAndGeneratedMetadata() {
    String content = "mensaje de prueba";
    ArgumentCaptor<Message> messageCaptor = ArgumentCaptor.forClass(Message.class);

    messageService.send(content);

    verify(publisher).publish(messageCaptor.capture());
    Message publishedMessage = messageCaptor.getValue();

    assertNotNull(publishedMessage.id());
    assertEquals(content, publishedMessage.content());
    assertNotNull(publishedMessage.timestamp());
    assertEquals(publishedMessage.id(), UUID.fromString(publishedMessage.id()).toString());
  }
}
