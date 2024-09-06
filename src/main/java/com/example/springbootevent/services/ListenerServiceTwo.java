package com.example.springbootevent.services;

import com.example.springbootevent.models.CustomApplicationEvent;
import com.example.springbootevent.models.ValueObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ListenerServiceTwo {

    public void process(ValueObject valueObject) {
        log.info("Event processing completed for value {} on service two", valueObject);
    }

    @EventListener
    @Async
    public void onApplicationEvent(CustomApplicationEvent event) {
        log.info("Received event {} on service two and thread {}", event.getValue(), Thread.currentThread().getName());
        process(event.getValue());
    }
}
