package com.navana.zencaservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ZencaServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZencaServiceDiscoveryApplication.class, args);
	}

}
