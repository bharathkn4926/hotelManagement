package com.staffdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
//@EnableSwagger2
public class StaffDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffDetailsServiceApplication.class, args);
	}

}
