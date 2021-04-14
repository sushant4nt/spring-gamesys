package org.example.springapp.daos;

import org.example.springapp.AppContextConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppContextConfig.class)
@ActiveProfiles("dev")
@Transactional // <!-- each tx will be rolled back after test execution by default
public class JdbcMovieDaoTest {

    @Autowired
    private MovieDao dao;

    @Test
    public void testFindAll() {
        assertEquals(10, dao.findAll().size());
    }

    @Test
    public void testFindById() {
        assertEquals("Selma", dao.findById(4).getTitle());
    }

    // TODO: implement the remaining tests

    @Test
    public void testFindByTitleAndReleaseYear() {
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testDelete() {
    }
}
