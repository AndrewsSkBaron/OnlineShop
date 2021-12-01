package com.onlineStore.coherent.sort;

import product.Product;

import java.util.Comparator;


public class SortByRate implements Comparator<Product> {
    @Override
    public int compare(Product rate1, Product rate2) {
        if (rate1.getRate() > rate2.getRate()) {
            return 1;
        }
        if (rate1.getRate() == rate2.getRate()) {
            return 0;
        }
        return -1;
    }
}
