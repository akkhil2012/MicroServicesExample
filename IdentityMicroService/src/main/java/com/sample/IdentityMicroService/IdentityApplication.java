package com.sample.IdentityMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


	@SpringBootApplication
	//@EnableJpaRepositories(basePackageClasses=UserRepository.class)
	public class IdentityApplication {
		public static void main(String[] args) {
			System.setProperty("server.servlet.context-path", "/IdentityService");
			System.setProperty("spring.config.name", "identity-server");
			SpringApplication.run(IdentityApplication.class, args);
		}

}
