package com.example.springbootevent.services;

import com.example.springbootevent.models.CustomApplicationEvent;
import com.example.springbootevent.models.ValueObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublisherService {
    private final ApplicationEventPublisher applicationEventPublisher;

    public void process(ValueObject valueObject) {
        log.info("Publishing...");
        applicationEventPublisher.publishEvent(new CustomApplicationEvent(this, valueObject));
        log.info("Published!");
    }
}
