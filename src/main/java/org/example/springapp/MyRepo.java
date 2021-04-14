package org.example.springapp;

import org.springframework.stereotype.Component;

@Component
public class MyRepo implements Repo {

    @Override
    public String getSomeData() {
        return "MyRepo's data";
    }
}
