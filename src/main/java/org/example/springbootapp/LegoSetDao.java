package org.example.springbootapp;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@CacheConfig(cacheNames = "legoSets")
public interface LegoSetDao {

    List<LegoSet> getAll();

    @Cacheable(key = "#a0")
    LegoSet getByItemNumber(int itemNumber);

    @CachePut(key = "#result.itemNumber")
    LegoSet add(LegoSet legoSet);

    @CacheEvict
    void deleteByItemNumber(int itemNumber);
}
