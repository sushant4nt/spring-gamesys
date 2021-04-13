package org.example.springapp;

public class MyService {

    private Repo repo;

    public MyService(Repo repo) {
        this.repo = repo;
    }

    public String getSomeData() {
        String data = repo.getSomeData();
        return String.format("From service: %s", data);
    }
}
