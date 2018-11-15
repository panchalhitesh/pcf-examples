package com.codenotfound.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Receiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }

  @Value("${topic.boot}")
  private String topicName;

  @PostConstruct
  public void init(){
    LOGGER.info("Receiver initialize='{}'",topicName);
  }

  @KafkaListener(topics = "${topic.boot}")
  public void receive(ConsumerRecord<?, ?> consumerRecord) {
    LOGGER.info("received data='{}'", consumerRecord.toString());
    latch.countDown();
  }
}
