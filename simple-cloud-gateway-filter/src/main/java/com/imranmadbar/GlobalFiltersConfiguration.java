package com.imranmadbar;

import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalFiltersConfiguration {

    final Logger logger = LoggerFactory.getLogger(GlobalFiltersConfiguration.class);
    public static final ImmutableList<String> HEADERS_LIST =
            ImmutableList.of(
                    "Host",
                    "User-Agent"

            );
    @Bean
    public GlobalFilter generalFilter() {
        return (exchange, chain) -> {
            HEADERS_LIST.forEach((hedName)-> {
                logger.info(hedName+": "+exchange.getRequest().getHeaders().getFirst(hedName));

            });
            return chain.filter(exchange);
        };
    }


}