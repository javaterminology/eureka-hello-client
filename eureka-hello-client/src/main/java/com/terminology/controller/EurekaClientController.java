package com.terminology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/hello/client")
public class EurekaClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public void callEurekaServer_Service(){
		
		String url = "http://hello-server/rest/hello/server";
		restTemplate.getForObject(url, String.class);
		
	}
	
}
