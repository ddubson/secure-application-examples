package com.ddubson.poc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "model")
@EntityScan(basePackages = "model")
@ComponentScan(basePackages = { "config", "model", "repository", "service", "core" })
public class Application {
	static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Throwable {
		log.info("Starting app.");
		SpringApplication.run(Application.class, args);
	}
}
