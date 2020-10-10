package com.admbootup.runphase.beneficiaryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.admbootup.runphase.beneficiaryservice")
@EnableDiscoveryClient
public class BeneficiaryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeneficiaryServiceApplication.class, args);
	}

}