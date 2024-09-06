package com.example.springbootevent;

import com.example.springbootevent.models.ValueObject;
import com.example.springbootevent.services.ListenerServiceOne;
import com.example.springbootevent.services.ListenerServiceTwo;
import com.example.springbootevent.services.PublisherService;
import lombok.val;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.Duration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest(properties = {
        "app.test=true"
})
class SpringBootEventApplicationTests {

    @Autowired
    private PublisherService publisherService;

    @SpyBean
    private ListenerServiceOne listenerServiceOne;

    @SpyBean
    private ListenerServiceTwo listenerServiceTwo;


    @Test
    void contextLoads() {
    }

    @Test
    void whenPublisherPublishesAnEventItIsReceivedOnServices() {
        //given
        val value = new ValueObject("test");
        //when
        publisherService.process(value);

        //then
        Awaitility
                .await()
                .atMost(Duration.ofSeconds(2))
                .untilAsserted(() -> {
                    verify(listenerServiceOne).process(value);
                    verify(listenerServiceTwo).process(value);
                });

    }
}
