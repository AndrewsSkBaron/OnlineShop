package com.onlineStore.coherent.model;

public class Sort {
    private String name;
    private int price;
    private int rate;

    public Sort(String name, int price, int rate) {
        this.name = name;
        this.price = price;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rate=" + rate +
                '}';
    }
}
