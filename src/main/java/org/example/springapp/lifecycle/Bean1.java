package org.example.springapp.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Bean1 implements InitializingBean, DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean 1 about to be destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean 1 properties set");
    }
}
