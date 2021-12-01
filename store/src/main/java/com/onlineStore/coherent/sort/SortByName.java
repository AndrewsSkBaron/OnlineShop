package com.onlineStore.coherent.sort;

import product.Product;

import java.util.Comparator;

public class SortByName implements Comparator<Product> {

    @Override
    public int compare(Product name1, Product name2) {

        return name1.getName().compareTo(name2.getName());
    }
}
