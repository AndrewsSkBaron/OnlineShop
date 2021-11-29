package com.onlineStore.coherent.sort;


import product.Product;

import java.util.Comparator;

public class SortByPrice implements Comparator<Product> {
    @Override
    public int compare(Product price1, Product price2) {
        if (price1.getPrice() < price2.getPrice()) {
            return 1;
        }

        if (price1.getPrice() == price2.getPrice()) {
            return 0;
        }

        return -1;
    }

}
