package org.example.springapp.spel;

public class Biscuit {

    private String type;
    private boolean isPartChocolate;

    public Biscuit(String type, boolean isPartChocolate) {
        this.type = type;
        this.isPartChocolate = isPartChocolate;
    }

    public Biscuit() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPartChocolate() {
        return isPartChocolate;
    }

    public void setPartChocolate(boolean partChocolate) {
        isPartChocolate = partChocolate;
    }
}
