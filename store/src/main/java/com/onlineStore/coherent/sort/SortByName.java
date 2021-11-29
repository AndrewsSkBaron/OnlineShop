package com.onlineStore.coherent.sort;

import product.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortByName implements Comparator<Product> {
    List<Product> productsAll = new ArrayList<>();

    @Override
    public int compare(Product name1, Product name2) {
        if (productsAll.indexOf(name1.getName().toLowerCase()) < productsAll.indexOf(name2.getName())) {

        }
        return name1.getName().compareTo(name2.getName());
    }
}
