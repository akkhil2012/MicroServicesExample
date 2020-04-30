package com.usr.mgmt.management_project_db.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("com.usr.mgmt.management_project_db")
public class StorageApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/storageService");
		System.setProperty("spring.config.name", "storage-server");
		SpringApplication.run(StorageApplication.class, args);
	}
}
