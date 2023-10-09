package com.microservices.employeeservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeeServiceApplication {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
