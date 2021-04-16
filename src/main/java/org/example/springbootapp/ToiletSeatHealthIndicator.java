package org.example.springbootapp;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ToiletSeatHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (new Random().nextBoolean()) {
            return Health.up().build();
        } else {
            return Health.down().build();
        }
    }
}
