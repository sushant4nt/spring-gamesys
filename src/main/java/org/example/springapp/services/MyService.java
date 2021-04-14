package org.example.springapp.services;

import org.springframework.stereotype.Component;

@Component
public class MyService implements Service {

    @Override
    public void doSomething() {
        System.out.println("Doing something");
    }

    @Override
    public void throwSomething() throws Exception {
        System.out.println("Throwing something");
        throw new Exception();
    }
}
