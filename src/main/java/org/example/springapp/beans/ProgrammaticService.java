package org.example.springapp.beans;

import org.example.springapp.exceptions.MySpecialException;

public class ProgrammaticService {

    private Dao dao;

    public ProgrammaticService(Dao dao) {
        this.dao = dao;
    }

    public String addNew(String thing) {
        return dao.insertRecord(thing);
    }

    public void throwUncheckedException() {
        throw new RuntimeException();
    }

    public void throwCheckedException() throws Exception {
        throw new Exception();
    }

    public void throwSpecialCheckedException() throws MySpecialException {
        throw new MySpecialException();
    }
}
