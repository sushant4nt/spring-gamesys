package org.example.springapp.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Bean2 {

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("Bean 2 about to be destroyed");
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean 2 properties set");
    }
}
