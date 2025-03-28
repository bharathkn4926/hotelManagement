package com.roomdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
//@EnableSwagger2
public class RoomDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomDetailsServiceApplication.class, args);
	}

}
