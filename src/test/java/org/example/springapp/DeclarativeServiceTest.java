package org.example.springapp;

import org.example.springapp.beans.DeclarativeService;
import org.example.springapp.exceptions.MySpecialException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppContextConfig.class)
public class DeclarativeServiceTest {

    @Autowired
    private DeclarativeService service;

    @Test
    public void testAddNew() {
        assertEquals("thing", service.addNew("thing"));
    }

    @Test
    public void testThrowUncheckedException() {
        assertThrows(RuntimeException.class, () -> service.throwUncheckedException());
    }

    @Test
    public void testThrowCheckedException() {
        assertThrows(Exception.class, () -> service.throwCheckedException());
    }

    @Test
    public void testThrowSpecialCheckedException() {
        assertThrows(MySpecialException.class, () -> service.throwSpecialCheckedException());
    }
}
