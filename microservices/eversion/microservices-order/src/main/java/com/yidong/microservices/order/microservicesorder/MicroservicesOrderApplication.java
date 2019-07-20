package com.yidong.microservices.order.microservicesorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicesOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesOrderApplication.class, args);
	}

}
