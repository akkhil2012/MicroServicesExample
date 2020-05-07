package com.sample.glossaryService.GlossaryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-10
 */
@SpringBootApplication
@ComponentScan(value = "com.sample.glossaryService.GlossaryService")
public class RestApiApplication {
    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/bgService");
		System.setProperty("spring.config.name", "bg-server");
		SpringApplication.run(RestApiApplication.class, args);
    }
}