package org.sid.eurekadiscoveryv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoveryV1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscoveryV1Application.class, args);
	}

}
