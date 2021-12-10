package com.onlineStore.coherent.order;

import product.Product;

import java.util.List;


public class Order {
    private List<Product> addedProduct;

    public Order(List<Product> addedProduct) {
        this.addedProduct = addedProduct;
    }

    @Override
    public String toString() {
        return "Order" + '\n' + addedProduct + '\n'  ;
    }
}
