package com.example.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator; // Correct import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExternalUrlController implements HealthIndicator {

    private final RestTemplate restTemplate;

    public ExternalUrlController() {
        this.restTemplate = new RestTemplate(); // Initialize RestTemplate
    }

    // This endpoint returns health status based on Spring Boot's health actuator
    @Override
    @GetMapping("/health")
    public Health health() {
        // Check if the application is healthy (can also customize further)
        return Health.up().withDetail("status", "UP").build();
    }

    @GetMapping("/external")
    public String getExternalUrlData(@RequestParam String url) {
        // Make a GET request to the external URL passed in as a query parameter
        String response = restTemplate.getForObject(url, String.class);
        return response; // Return the response from the external URL
    }
}
