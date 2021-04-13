package org.example.springapp.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppContextConfig {

    @Bean(initMethod = "afterPropertiesSet", destroyMethod = "destroy")
    public Bean3 bean3() {
        return new Bean3();
    }
}
