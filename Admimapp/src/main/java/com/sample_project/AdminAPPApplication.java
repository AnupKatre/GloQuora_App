package com.sample_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminAPPApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminAPPApplication.class, args);
	}

}
