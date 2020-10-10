package com.admbootup.runphase.loginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
public class LoginServiceApplication {

	 @Bean
	 BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
	 }
	
	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}

}