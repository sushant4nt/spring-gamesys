package org.example.springbootapp.models;

import java.util.List;

public class Role {

    private String name;
    private List<Privilege> privileges;

    public Role(String name, List<Privilege> privileges) {
        this.name = name;
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", privileges=" + privileges +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
