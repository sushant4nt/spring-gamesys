package org.example.springapp.mixing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ConfigMixingTest {

    private ApplicationContext context;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(AppContextConfig1.class);
    }

    @Test
    public void testContainerConfig() {
        Bean1 bean1 = context.getBean(Bean1.class);
        Bean2 bean2 = context.getBean(Bean2.class);
        assertNotNull(bean1);
        assertNotNull(bean2);
        assertNotNull(bean1.getBean2());
        assertSame(bean2, bean1.getBean2());
    }
}
