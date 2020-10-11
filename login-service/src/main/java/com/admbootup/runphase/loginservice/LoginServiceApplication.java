package com.admbootup.runphase.loginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class LoginServiceApplication {

	 @Bean
	 BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
	 }
	
	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
