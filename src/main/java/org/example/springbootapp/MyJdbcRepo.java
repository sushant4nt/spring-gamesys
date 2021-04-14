package org.example.springbootapp;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class MyJdbcRepo {

    public MyJdbcRepo(DataSource dataSource) {
    }
}
