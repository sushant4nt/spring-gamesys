package org.example.springapp.profiles;

public class GreetingService {

    private String greeting;

    public GreetingService(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
