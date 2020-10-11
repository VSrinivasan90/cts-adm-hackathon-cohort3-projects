package com.admbootup.runphase.eurekanamingserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaNamingServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaNamingServiceProviderApplication.class, args);
	}

}
