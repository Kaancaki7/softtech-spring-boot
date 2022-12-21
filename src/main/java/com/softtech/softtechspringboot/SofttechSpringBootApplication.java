package com.softtech.softtechspringboot;

import com.softtech.softtechspringboot.dependencyexamples.WebService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SofttechSpringBootApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SofttechSpringBootApplication.class, args);

		WebService webService1 = applicationContext.getBean(WebService.class);
		WebService webService2 = applicationContext.getBean(WebService.class);

		//WebService prototype yaparsak @Scope ile webService1 ve webService2 olarak 2 tane farklı nesne oluşur
		//bu yüzden alttaki eşitlik false olur ama default olarak bırakırsak true olur.
		System.out.println(webService1 == webService2);
		//fakat singleton sayesinde bağlandığı nesne birtane olacak o yüzden aynı nesneyi verecek alttaki eşitlik true olur
		System.out.println(webService1.getResponseConverter() == webService2.getResponseConverter());

		//webService.convertResponse();

	}

}
