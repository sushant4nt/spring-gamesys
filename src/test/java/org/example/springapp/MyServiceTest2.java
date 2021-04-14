package org.example.springapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MyServiceTest2 {

    private MyService service;
    private Repo mockRepo;

    @BeforeEach
    public void setUp() {
        mockRepo = Mockito.mock(Repo.class);
        service = new MyService(mockRepo);
    }

    @Test
    public void testGetSomeData() {
        when(mockRepo.getSomeData()).thenReturn("data");
        assertEquals("From service: data", service.getSomeData());
        verify(mockRepo).getSomeData();
    }
}
