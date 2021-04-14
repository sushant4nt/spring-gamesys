package org.example.springbootapp;

import org.springframework.stereotype.Component;

@Component
public class Bean1 {

    private Bean2 bean2;

    public Bean1(Bean2 bean2) {
        this.bean2 = bean2;
    }

    public Bean2 getBean2() {
        return bean2;
    }
}
