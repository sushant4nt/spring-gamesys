package org.example.springbootapp;

import java.util.List;

public interface LegoSetDao {

    List<LegoSet> getAll();

    LegoSet getByItemNumber(int itemNumber);

    LegoSet add(LegoSet legoSet);

    void deleteByItemNumber(int itemNumber);
}
