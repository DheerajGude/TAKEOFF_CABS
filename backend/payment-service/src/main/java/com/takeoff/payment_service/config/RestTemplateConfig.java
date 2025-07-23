package com.paymentservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced // Enables client-side load-balancing via Eureka
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
