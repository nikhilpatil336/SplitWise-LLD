package com.example.Split_Wise_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SplitWiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitWiseApplication.class, args);
		System.out.println("Ready");
	}
}