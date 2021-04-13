package org.example.springapp.properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertyResolverTest {

    private ApplicationContext context;
    private PropertyResolver resolver;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(AppContextConfig.class);
        resolver = context.getBean(PropertyResolver.class);
    }

    @Test
    public void testPropsResolvedViaPropertiesFile() {
        assertEquals("Stuart", resolver.getMyName());
        assertEquals("Hello Stuart", resolver.getGreeting());
        assertEquals("postgres", resolver.getDb());
    }

    @Test
    public void testSystemProps() {
        assertEquals("1.8", resolver.getJavaVersion());
    }

    @Test
    public void testEnvVariableProps() {
        assertEquals("/Users/trainer", resolver.getUsersHomeDir());
    }
}
