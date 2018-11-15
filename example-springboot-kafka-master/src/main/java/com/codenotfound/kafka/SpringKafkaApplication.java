package com.codenotfound.kafka;

import com.codenotfound.kafka.consumer.Receiver;
import com.codenotfound.kafka.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringKafkaApplication implements CommandLineRunner{

  public static void main(String[] args) {
    SpringApplication.run(SpringKafkaApplication.class, args);
  }

  @Autowired
  private Sender sender;

  @Autowired
  private Receiver receiver;

  @Value("${topic.boot}")
  private String BOOT_TOPIC;


  @Override
  public void run(String... strings) throws Exception {
    sender.send(BOOT_TOPIC, "Hello Boot!");

    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    System.out.println(receiver.getLatch().getCount());
  }
}
