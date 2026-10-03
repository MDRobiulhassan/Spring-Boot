package com.example.api_gateway.filter;

import com.example.api_gateway.service.JwtService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthenticationGatewayFilterFactory
        extends AbstractGatewayFilterFactory<AuthenticationGatewayFilterFactory.Config> {

    private final JwtService jwtService;

    public AuthenticationGatewayFilterFactory(JwtService jwtService) {
        super(Config.class);
        this.jwtService = jwtService;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {

            if (!config.isEnabled()) return chain.filter(exchange);

            String authorizationHeader = exchange.getRequest()
                    .getHeaders()
                    .getFirst("Authorization");

            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            String token = authorizationHeader.substring(7);

            Long userId = jwtService.getUserIdFromToken(token);

            exchange = exchange.mutate()
                    .request(request -> request.header(
                            "X-User-Id",
                            String.valueOf(userId)
                    ))
                    .build();

            return chain.filter(exchange);
        };
    }

    @Data
    public static class Config {
        private boolean enabled;
    }
}