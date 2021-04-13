package org.example.springapp.mixing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppContextConfig2.class)
public class AppContextConfig1 {

    @Bean
    public Bean1 bean1(Bean2 bean2) {
        return new Bean1(bean2);
    }
}
