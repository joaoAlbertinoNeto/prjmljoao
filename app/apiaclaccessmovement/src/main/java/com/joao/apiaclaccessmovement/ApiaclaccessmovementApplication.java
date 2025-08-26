package com.joao.apiaclaccessmovement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class ApiaclaccessmovementApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiaclaccessmovementApplication.class, args);
	}
}
