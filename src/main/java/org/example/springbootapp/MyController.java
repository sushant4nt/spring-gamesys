package org.example.springbootapp;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
public class MyController {

    private Counter counter;

    public MyController(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("hello.count");
    }

    @Timed
    @GetMapping
    public String hello() throws InterruptedException {
        Thread.sleep(new Random().nextInt(1000));
        counter.increment();
        return "Hello";
    }
}
