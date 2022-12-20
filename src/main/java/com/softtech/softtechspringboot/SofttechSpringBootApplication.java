package com.softtech.softtechspringboot;

import com.softtech.softtechspringboot.dependencyexamples.WebService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SofttechSpringBootApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SofttechSpringBootApplication.class, args);

		WebService webService = applicationContext.getBean(WebService.class);

		webService.convertResponse();

	}

}
