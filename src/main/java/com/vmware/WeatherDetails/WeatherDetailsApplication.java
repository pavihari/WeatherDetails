package com.vmware.WeatherDetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Slf4j
public class WeatherDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherDetailsApplication.class, args);
		log.info("hello");

	}

}
