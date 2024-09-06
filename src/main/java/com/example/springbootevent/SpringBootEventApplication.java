package com.example.springbootevent;

import com.example.springbootevent.models.ValueObject;
import com.example.springbootevent.services.PublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringBootEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEventApplication.class, args);
    }

    @Bean
    @ConditionalOnProperty(prefix = "app", value = "test", havingValue = "false", matchIfMissing = true)
    public CommandLineRunner commandLineRunner(PublisherService service) {
        return args -> IntStream
                .rangeClosed(1, 10)
                .forEach(x -> service.process(new ValueObject(UUID.randomUUID().toString())));
    }
}
