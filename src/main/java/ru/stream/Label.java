package ru.stream;

import java.util.Objects;

public class Label {
    private String name;
    private float price;

    public Label(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Float.compare(price, label.price) == 0 && Objects.equals(name, label.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Label{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
