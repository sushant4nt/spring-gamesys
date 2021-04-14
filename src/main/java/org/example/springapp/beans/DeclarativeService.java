package org.example.springapp.beans;

import org.example.springapp.exceptions.MySpecialException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class DeclarativeService {

    private Dao dao;

    public DeclarativeService(Dao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = false)
    public String addNew(String thing) {
        return dao.insertRecord(thing);
    }

    public void throwUncheckedException() {
        throw new RuntimeException();
    }

    public void throwCheckedException() throws Exception {
        throw new Exception();
    }

    @Transactional(rollbackFor = MySpecialException.class)
    public void throwSpecialCheckedException() throws MySpecialException {
        throw new MySpecialException();
    }
}
