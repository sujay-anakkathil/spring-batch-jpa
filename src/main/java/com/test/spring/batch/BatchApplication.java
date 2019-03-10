package com.test.spring.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages="com.test.spring")
@SpringBootApplication
public class BatchApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}

}
