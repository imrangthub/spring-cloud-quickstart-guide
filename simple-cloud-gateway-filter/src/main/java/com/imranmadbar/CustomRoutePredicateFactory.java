package com.imranmadbar;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class CustomRoutePredicateFactory implements WebFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {


        String requestUrl = exchange.getRequest().getURI().toString();

        // Add your condition based on the request URL
        if (requestUrl.contains("/ping")) {
            System.out.println("this is  Pint url, Do notheing");
            return chain.filter(exchange);
        }
        System.out.println("###################333CustomRoutePredicateFactory, Do some thisng");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }

}