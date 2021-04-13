package org.example.springapp.mixing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContextConfig2 {

    @Bean
    public Bean2 bean2() {
        return new Bean2();
    }
}
