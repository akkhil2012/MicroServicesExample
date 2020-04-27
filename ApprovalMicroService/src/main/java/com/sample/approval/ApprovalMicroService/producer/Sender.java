package com.sample.approval.ApprovalMicroService.producer;


import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sample.approval.ApprovalMicroService.AuthenticationRequest;


@RestController
@RequestMapping("kafka")
public class Sender {

	 // private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Sender.class);

	  private final KafkaTemplate<Integer, AuthenticationRequest> kafkaTemplate;

	  
	  private static final String TOPIC = "example";

	  
	  public Sender(final KafkaTemplate<Integer, AuthenticationRequest> kafkaTemplate) {
	    this.kafkaTemplate = kafkaTemplate;
	  }

	
	  @PostMapping("/publish/users")
	 public String sendMessage(@RequestBody AuthenticationRequest authenticationRequest) {
	 // public String sendMessage(@RequestBody User user) {
	    kafkaTemplate.send(TOPIC, new AuthenticationRequest(authenticationRequest.getUserName(),authenticationRequest.getPassword()));
	      
        return "Published successfully";
	  }
	}