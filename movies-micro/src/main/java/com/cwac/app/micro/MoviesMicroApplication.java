package com.cwac.app.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MoviesMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesMicroApplication.class, args);
	}

}
