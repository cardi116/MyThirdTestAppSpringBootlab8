package ru.cher.MySecondTestAppSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/actuator")
public class ActuatorMockController {

    @GetMapping
    public Map<String, Object> actuatorIndex() {
        Map<String, Object> links = new HashMap<>();
        Map<String, String> self = Collections.singletonMap("href", "http://localhost:8082/actuator");
        Map<String, String> health = Collections.singletonMap("href", "http://localhost:8082/actuator/health");
        Map<String, String> info = Collections.singletonMap("href", "http://localhost:8082/actuator/info");

        links.put("self", self);
        links.put("health", health);
        links.put("info", info);
        return Collections.singletonMap("_links", links);
    }

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        Map<String, Object> components = new HashMap<>();
        components.put("db", Collections.singletonMap("status", "UP"));
        components.put("diskSpace", Collections.singletonMap("status", "UP"));
        response.put("components", components);
        return response;
    }

    @GetMapping("/info")
    public Map<String, Object> info() {
        Map<String, Object> app = new HashMap<>();
        app.put("name", "MySecondTestAppSpringBoot");
        app.put("description", "Spring Boot Web Application");
        app.put("version", "0.0.1-SNAPSHOT");
        return Collections.singletonMap("app", app);
    }
}