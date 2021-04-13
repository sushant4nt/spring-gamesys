package org.example.springapp.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyResolver {

    @Value("${myname}")
    private String myName;

    @Value("${greeting}")
    private String greeting;

    @Value("${db}")
    private String db;

    // From System.getProperties
    @Value("${java.specification.version}")
    private String javaVersion;

    @Value("${HOME}")
    private String usersHomeDir;

    public String getMyName() {
        return myName;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getDb() {
        return db;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getUsersHomeDir() {
        return usersHomeDir;
    }
}
