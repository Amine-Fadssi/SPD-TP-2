package org.sid.gatewayv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayV1Application {

	public static void main(String[] args) {
		SpringApplication.run(GatewayV1Application.class, args);
	}

	// another static way for defining gateway
	// @Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route((r)->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
				.route((r)->r.path("/products/**").uri("lb://PRODUCT-SERVICE"))
				.build();
	}
	// dynamic way for defining gateway (without knowing uri's or services names)
	// http://localhost:8888/CUSTOMER-SERVICE/customers
	@Bean
	DiscoveryClientRouteDefinitionLocator definitionLocator(
			ReactiveDiscoveryClient rdc,
			DiscoveryLocatorProperties properties
	){
		return new DiscoveryClientRouteDefinitionLocator(rdc, properties);
	}
}
