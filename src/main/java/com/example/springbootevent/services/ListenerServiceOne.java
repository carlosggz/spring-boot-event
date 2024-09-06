package com.example.springbootevent.services;

import com.example.springbootevent.models.CustomApplicationEvent;
import com.example.springbootevent.models.ValueObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ListenerServiceOne implements ApplicationListener<CustomApplicationEvent> {

    public void process(ValueObject valueObject) {
        log.info("Event processing completed for value {} on service one", valueObject);
    }

    @Override
    public void onApplicationEvent(CustomApplicationEvent event) {
        log.info("Received event {} on service one and thread {}", event.getValue(), Thread.currentThread().getName());
        process(event.getValue());
    }
}
