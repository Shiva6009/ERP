package com.example.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;


@EnableJpaRepositories("com.example.dao")
@EntityScan("com.example.model")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
@ComponentScan(basePackages = {"com.example.service" , "com.example.controller"})
@SpringBootApplication
public class ErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpApplication.class, args);
		System.out.println("Server Running Successfully!!!");
	}

}
