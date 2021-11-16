package com.onlineStore.coherent;

public class Product {
    private String nameProduct;
    private int rateProduct;
    private int priceProduct;

    public Product(String nameProduct, int rateProduct, int priceProduct) {
        this.nameProduct = nameProduct;
        this.rateProduct = rateProduct;
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getRateProduct() {
        return rateProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    @Override
    public String toString() {
        return "\n " + "Product{" +
                "nameProduct='" + nameProduct + '\'' +
                ", rateProduct=" + rateProduct +
                ", priceProduct=" + priceProduct +
                '}';
    }
}

