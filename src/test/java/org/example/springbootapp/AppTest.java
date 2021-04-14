package org.example.springbootapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AppTest {

    @Autowired
    private Bean1 bean1;

    @MockBean
    private Bean2 bean2;

    @Autowired
    private PropertyResolver propertyResolver;

    @Test
    public void testContainerConfig() {
        assertNotNull(bean1);
        assertNotNull(bean1.getBean2());
    }

    @Test
    public void testBean2IsAMock() {
        when(bean2.getString()).thenReturn("Hello");
        assertEquals("Hello", bean2.getString());
    }

    @Test
    public void testConfigProps() {
        assertEquals("James", propertyResolver.getChildren().get(0).getName());
    }
}
