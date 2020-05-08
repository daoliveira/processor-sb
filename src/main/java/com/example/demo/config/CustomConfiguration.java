package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {

	@Bean
	public MyConfig configService() {
		System.out.println("Configuring MyConfig");
		return new MyConfig();
	}
}

class MyConfig {

}