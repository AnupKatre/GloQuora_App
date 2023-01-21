package com.sample_project.GloQuora;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info = @Info(title = "GLO_Quora Portal", version = "1.0", description = "Here you can post your Blogs"))
public class GloQuoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(GloQuoraApplication.class, args);
	}

}
