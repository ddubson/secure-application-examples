package com.ddubson.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "model")
@EntityScan(basePackages = "model")
@ComponentScan(basePackages = { "model", "repository", "service", "core" })
@EnableWebSecurity
public class Application {
	public static void main(String[] args) throws Throwable {
		SpringApplication.run(Application.class, args);
	}
}
