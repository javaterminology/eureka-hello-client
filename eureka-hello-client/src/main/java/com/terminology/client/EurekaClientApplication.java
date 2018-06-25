package com.terminology.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@EnableDiscoveryClient
@ComponentScan(basePackages="com.terminology")
@SpringBootApplication
public class EurekaClientApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaClientApplication.class, args);
        
    }
    
    //@Configuration - spring boot auto loads configuration class before eureka server loads configs.
    //so spring cloud Eureka will have control for this RestTemplate
    
    @Configuration
    class Config{
    	@LoadBalanced
    	@Bean
    	public RestTemplate restTemplate(){
    		return new RestTemplate();
    	}
    }
    
    
	/*@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}*/
 	
}
