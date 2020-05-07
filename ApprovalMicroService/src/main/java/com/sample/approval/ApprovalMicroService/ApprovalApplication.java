package com.sample.approval.ApprovalMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



	@SpringBootApplication
	//@EnableJpaRepositories(basePackageClasses=UserRepository.class)
	public class ApprovalApplication {
		public static void main(String[] args) {
			System.setProperty("server.servlet.context-path", "/ApprovalService");
			System.setProperty("spring.config.name", "approval-server");
			SpringApplication.run(ApprovalApplication.class, args);
		}
		
		
}
