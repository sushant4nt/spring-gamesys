package org.example.springbootapp;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "myname")
public class MyNameEndpoint {

    private String myName = "Stuart";

    @ReadOperation
    public String getMyName() {
        return myName;
    }

    @WriteOperation
    public void setMyName(String myName) {
        this.myName = myName;
    }
}
