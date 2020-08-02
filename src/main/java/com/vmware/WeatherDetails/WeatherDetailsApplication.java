package com.vmware.WeatherDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class WeatherDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherDetailsApplication.class, args);
		System.out.println("hello");
	}

}
