package com.sample.notification.NotificationService.app;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

    @Configuration
	@EnableKafka
	public class KafkaConsumerConfig {

	 /* @Value("${kafka.bootstrap.servers}")
	  private String bootstrapServers;*/

	  @Bean
	  public Map<String, Object> consumerConfig() {
	    final Map<String, Object> props = new HashMap<>();

	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "example");

	    return props;
	  }

	  @Bean
	  public ConsumerFactory<Integer, String> consumerFactory() {
	    return new DefaultKafkaConsumerFactory<Integer, String>(consumerConfig());
	  }

	  @Bean
	  public ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {

	    final ConcurrentKafkaListenerContainerFactory<Integer, String> factory
	        = new ConcurrentKafkaListenerContainerFactory<Integer, String>();

	    factory.setConsumerFactory(consumerFactory());

	    return factory;
	  }

	  @Bean
	  public Consumer consumer() {
	    return new Consumer();
	  }
	}