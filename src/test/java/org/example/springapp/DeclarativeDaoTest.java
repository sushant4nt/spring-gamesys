package org.example.springapp;

import org.example.springapp.beans.Dao;
import org.example.springapp.beans.DeclarativeDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.IllegalTransactionStateException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppContextConfig.class)
public class DeclarativeDaoTest {

    @Autowired
    private Dao dao;

    @Test
    public void testInsertRecord() {
        assertThrows(IllegalTransactionStateException.class, () -> dao.insertRecord("thing"));
    }
}
