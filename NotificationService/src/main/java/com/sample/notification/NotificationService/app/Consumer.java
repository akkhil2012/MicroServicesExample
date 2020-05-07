package com.sample.notification.NotificationService.app;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;

public class Consumer {

	/*
	 * 
	 * ADD THE SCRIPT SO AS TO START THE KAFLA AND ZOOKEEPER
	 * 
	 * ======================================================================================
	 * 
	 *   need to provide script here****************************************************
	 * 
	 * 
	 * 
	 */
	
	private final CountDownLatch latch = new CountDownLatch(1);
	
	
	@KafkaListener(topics="approval")
	public void receiveMessage(AuthenticationRequest request) {
		System.out.println("Message reeived.... " + request.getUserName()+"  "+ request.getPassword());
		latch.countDown();
	}
	
	
	/*public CountDownLatch getLatch() {
		
	}*/
	
}
