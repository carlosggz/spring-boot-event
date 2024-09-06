package com.example.springbootevent.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.concurrent.Executors;

@Configuration
public class AppConfiguration {

    @Bean("applicationEventMulticaster")
    public ApplicationEventMulticaster customApplicationEventMulticaster(@Value("${app.threads-number:5}") int threadsNUmber) {
        var eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(Executors.newFixedThreadPool(threadsNUmber));
        return eventMulticaster;
    }
}
