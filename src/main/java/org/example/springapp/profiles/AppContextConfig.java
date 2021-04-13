package org.example.springapp.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppContextConfig {

    @Profile("default")
    @Bean
    public GreetingService defaultGreetingService() {
        return new GreetingService("Hello");
    }

    @Profile("British")
    @Bean
    public GreetingService britishGreetingService() {
        return new GreetingService("How do you do?");
    }

    @Bean
    public SomeOtherBean someOtherBean() {
        return new SomeOtherBean();
    }
}
