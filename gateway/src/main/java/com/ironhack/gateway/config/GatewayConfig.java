package com.ironhack.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user", r -> r.path("/api/user/**")
                        .uri("lb://users-micro"))
                .route("account", r -> r.path("/api/account/**")
                        .uri("lb://accounts-micro")
                ).build();
    }
}