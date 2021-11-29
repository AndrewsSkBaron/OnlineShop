package com.onlineStore.coherent.model;

public class Sort {
    private String name;
    private String price;
    private String rate;

    public Sort() {
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getRate() {
        return rate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
