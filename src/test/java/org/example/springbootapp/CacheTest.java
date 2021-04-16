package org.example.springbootapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.util.AopTestUtils;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {App.class, CacheTest.Config.class})
public class CacheTest {

    @Configuration
    public static class Config {

        @Bean
        public LegoSetDao legoSetDao() {
            return Mockito.mock(LegoSetDao.class);
        }
    }

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private LegoSetDao proxiedMockDao;

    private LegoSetDao actualMockDao;

    private LegoSet set1, set2;

    private LegoSet getFromCache(int itemNumber) {
        return cacheManager.getCache("legoSets").get(itemNumber, LegoSet.class);
    }

    @BeforeEach
    public void setUp() {
        actualMockDao = AopTestUtils.getTargetObject(proxiedMockDao);
        set1 = new LegoSet(12345, "Police Car", "City", BigDecimal.valueOf(4.99));
        set2 = new LegoSet(23456, "Train", "City", BigDecimal.valueOf(79.99));
    }

    @AfterEach
    public void tearDown() {
        reset(actualMockDao);
        cacheManager.getCache("legoSets").clear();
    }

    @Test
    public void testGetByItemNumberReturnsFromCacheOnSecondInvocation() {

        int itemNumber = set1.getItemNumber();
        assertNull(getFromCache(itemNumber));

        when(actualMockDao.getByItemNumber(itemNumber)).thenReturn(set1);

        // First invocation
        LegoSet legoSet = proxiedMockDao.getByItemNumber(itemNumber);
        assertNotNull(getFromCache(itemNumber));
        verify(actualMockDao, times(1)).getByItemNumber(itemNumber);

        // Second invocation
        legoSet = proxiedMockDao.getByItemNumber(itemNumber);
        verifyNoMoreInteractions(actualMockDao);
    }

    // TODO: test adding a new LegoSet and deleting an existing LegoSet
}
