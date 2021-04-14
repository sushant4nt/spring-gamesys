package org.example.springapp;

import org.example.springapp.services.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContextConfig.class);
        Service service = context.getBean(Service.class);
        service.doSomething();
        service.throwSomething();
    }
}
