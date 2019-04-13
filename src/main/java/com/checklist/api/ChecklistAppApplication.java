package com.checklist.api;

import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ChecklistAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChecklistAppApplication.class, args);
	}

}
