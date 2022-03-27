package com.fis.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class UnitTest01SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTest01SpringJpaApplication.class, args);
	}

}
