package com.navana.miapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
@RestController
public class MiApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiApiGatewayApplication.class, args);
	}

	@Bean
	public ServerCodecConfigurer serverCodecConfigurer() {
		return ServerCodecConfigurer.create();
	}

	// tag::route-locator[]
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {

		String httpUri = "http://10.10.2.250:8080"; //uriConfiguration.getHttpbin();

		return builder.routes()
				.route("router_001", r -> r
						.path("/books")
						.filters(f->f
								.prefixPath("/mypath")
								.rewritePath("/books","/APIC/DATA.json"))
						.uri(httpUri)
				)
				.build();
	}

	@RequestMapping("/fallback")
	public Mono<String> fallback() {
		return Mono.just("fallback");
	}
}
