package com.sample.notification.NotificationService.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
	public class NotificationApplication {

		public static void main(final String[] args) {
			System.setProperty("server.servlet.context-path", "/NotificationService");
			System.setProperty("spring.config.name", "notification-server");
			SpringApplication.run(NotificationApplication.class, args);
		}
	}
	


