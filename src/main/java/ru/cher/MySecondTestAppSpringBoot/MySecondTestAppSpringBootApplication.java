package ru.cher.MySecondTestAppSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;

@SpringBootApplication
public class MySecondTestAppSpringBootApplication {

    public static void main(String[] args) {
        // Поднимаем веб-сервер H2 на отдельном порту 8083
        try {
            org.h2.tools.Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8083").start();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SpringApplication.run(MySecondTestAppSpringBootApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}