package com.embarkx.jobms.JobFolder;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced // annotation to enable client-side load balancing and allow the use of service names instead of hardcoded URLs
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}
