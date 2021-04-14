package org.example.springapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppContextConfig.class, AppContextTestConfig.class})
public class MyServiceTest1 {

    @Autowired
    private MyService service;

    @Autowired
    private Repo mockRepo;

    @Test
    public void testGetSomeData() {
        when(mockRepo.getSomeData()).thenReturn("data");
        assertEquals("From service: data", service.getSomeData());
        verify(mockRepo).getSomeData();
    }
}
