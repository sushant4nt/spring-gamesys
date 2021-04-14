package org.example.springapp.beans;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class DeclarativeDao implements Dao {

    @Override
    public String insertRecord(String thing) {
        // TODO
        return thing;
    }
}
