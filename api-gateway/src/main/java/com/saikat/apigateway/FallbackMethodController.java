package com.saikat.apigateway;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest")
public class FallbackMethodController {

	
	@GetMapping("/userServiceFallback")
	public String userServiceFallbackMethod() {
		
		return "User Service is not working "+
		"Please try again later";
	}
	
	@GetMapping("/departmentServiceFallback")
	public String departmentServiceFallbackMethod() {
		
		return "Department Service is not working "+
		"Please try again later";
	}
	
	@HystrixCommand(fallbackMethod = "userServiceFallbackMethod", commandKey = "hello", groupKey = "hello")
	@GetMapping("/hello")
	public String hello() {
		
		if(RandomUtils.nextBoolean())
			throw new RuntimeException("Failed");
		
		return "Hello";
	}
	
	
}
