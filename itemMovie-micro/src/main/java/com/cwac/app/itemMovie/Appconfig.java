package com.cwac.app.itemMovie;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Appconfig {
	
	@Bean("clienteRest")
	@LoadBalanced
	public RestTemplate regustrarRestTemplate(){
	return new RestTemplate();
	}
}
