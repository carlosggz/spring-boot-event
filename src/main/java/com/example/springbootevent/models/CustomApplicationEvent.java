package com.example.springbootevent.models;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CustomApplicationEvent extends ApplicationEvent {

    private final ValueObject value;

    public CustomApplicationEvent(Object source, ValueObject value) {
        super(source);
        this.value = value;
    }
}
