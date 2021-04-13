package org.example.springapp.lifecycle;

public class Bean3 {

    public void destroy() throws Exception {
        System.out.println("Bean 3 about to be destroyed");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean 3 properties set");
    }
}
