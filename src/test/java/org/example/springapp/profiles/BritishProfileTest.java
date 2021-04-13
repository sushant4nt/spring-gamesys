package org.example.springapp.profiles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BritishProfileTest {

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("British");
        context.register(AppContextConfig.class);
        context.refresh();
    }

    @Test
    public void testContainerConfig() {
        GreetingService service = context.getBean(GreetingService.class);
        assertEquals("How do you do?", service.getGreeting());
        assertNotNull(context.getBean(SomeOtherBean.class));
    }
}
