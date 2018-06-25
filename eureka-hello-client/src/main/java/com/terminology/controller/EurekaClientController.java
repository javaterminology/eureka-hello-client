package com.terminology.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableCircuitBreaker
@RequestMapping("/rest/hello/client")
public class EurekaClientController {
	
	Logger LOGGER = LoggerFactory.getLogger(EurekaClientController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(groupKey="hello",commandKey="client",fallbackMethod="fallback")
	@GetMapping
	public void callEurekaServer_Service(){
		
		String url = "http://hello-server/rest/hello/server";
		restTemplate.getForObject(url, String.class);
		
	}
	
	public void fallback(Throwable e){
		LOGGER.info("################### SERVER API GATEWAY FAILED ###############################");
	}
	
}
