package com.ashwani.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "API Gateway", version = "1.0", description = "Documentation API Gateway v1.0"))
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(r -> r.path("/review-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://REVIEWMS"))
				// .route(r -> r.path("/price-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://price-service"))
				.route(r -> r.path("/reviews/**").uri("lb://REVIEWMS"))
				// .route(r -> r.path("/reviews/{reviewId}").and().method(HttpMethod.PUT).uri("lb://REVIEWMS"))
				// .route(r -> r.path("/reviews/{reviewId}").and().method(HttpMethod.DELETE).uri("lb://REVIEWMS"))
				// .route(r -> r.path("/reviews").and().method(HttpMethod.GET).uri("lb://REVIEWMS"))
				// .route(r -> r.path("/reviews").and().method(HttpMethod.POST).uri("lb://REVIEWMS"))
				// .route(r -> r.path("/reviews").and().method(HttpMethod.PUT).uri("lb://REVIEWMS"))
				// .route(r -> r.path("/reviews").and().method(HttpMethod.DELETE).uri("lb://REVIEWMS"))
				// .route(r -> r.path("/api/v1/price").and().method(HttpMethod.GET).uri("lb://price-service"))
				.build();
	}
}
