package org.example.springapp.services;

/*
 * This is an example of the proxy that Spring will create resulting from AOP.
 */

public class MyServiceProxy implements Service {

    private MyService myService;

    public MyServiceProxy(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void doSomething() {
        System.out.println("Beginning transaction");
        myService.doSomething();
        System.out.println("Committing");
    }

    @Override
    public void throwSomething() throws Exception {
        System.out.println("Beginning transaction");
        myService.throwSomething();
        System.out.println("Committing");
    }
}
