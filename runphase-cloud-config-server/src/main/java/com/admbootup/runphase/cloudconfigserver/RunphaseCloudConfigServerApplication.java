package com.admbootup.runphase.cloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class RunphaseCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunphaseCloudConfigServerApplication.class, args);
	}

}