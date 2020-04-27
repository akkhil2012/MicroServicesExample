package com.sample.approval.ApprovalMicroService.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.sample.approval.ApprovalMicroService.AuthenticationRequest;

@Configuration
public class SenderConfig {

 /* @Value("${kafka.bootstrap.servers}")
  private String bootstrapServers;*/

  @Bean
  public Map<String, Object> producerConfig() {
    final Map<String, Object> props = new HashMap<String, Object>(4);

    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    //props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 5000);

    return props;
  }

  @Bean
  public ProducerFactory<Integer, AuthenticationRequest> producerFactory() {
    return new DefaultKafkaProducerFactory<Integer, AuthenticationRequest>(producerConfig());
  }

  @Bean
  public KafkaTemplate<Integer, AuthenticationRequest> kafkaTemplate() {
    return new KafkaTemplate<Integer, AuthenticationRequest>(producerFactory());
  }

  @Bean
  public Sender sender() {
    return new Sender(kafkaTemplate());
  }
}
