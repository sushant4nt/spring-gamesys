package org.example.springbootapp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class LegoSet implements Serializable {

    private int itemNumber;
    private String name;
    private String theme;
    private BigDecimal price;

    public LegoSet(int itemNumber, String name, String theme, BigDecimal price) {
        this.itemNumber = itemNumber;
        this.name = name;
        this.theme = theme;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LegoSet legoSet = (LegoSet) o;
        return Objects.equals(name, legoSet.name) && Objects.equals(theme, legoSet.theme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, theme);
    }

    @Override
    public String toString() {
        return "LegoSet{" +
                "itemNumber=" + itemNumber +
                ", name='" + name + '\'' +
                ", theme='" + theme + '\'' +
                ", price=" + price +
                '}';
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
