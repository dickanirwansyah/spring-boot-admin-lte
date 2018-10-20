package com.pmo.app.pmoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PmoServiceApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PmoServiceApplication.class);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PmoServiceApplication.class, args);
	}
}
