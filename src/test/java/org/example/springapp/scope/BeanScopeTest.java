package org.example.springapp.scope;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class BeanScopeTest {

    private ApplicationContext context;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(AppContextConfig.class);
    }

    @Test
    public void testPrototypeScopeBean() {
        PrototypeBean p1 = context.getBean(PrototypeBean.class);
        PrototypeBean p2 = context.getBean(PrototypeBean.class);
        assertNotSame(p1, p2);
    }

    @Test
    public void testSingletonBean() {
        SingletonBean s1 = context.getBean(SingletonBean.class);
        SingletonBean s2 = context.getBean(SingletonBean.class);
        assertSame(s1, s2);
    }
}
