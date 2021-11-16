package com.onlineStore.coherent;

import java.util.ArrayList;

public class Store {
    private ArrayList cat = new ArrayList<>();
    private Category category = new Category();
    public void getCat() {
        cat.add(category.getCategoryBear());
        cat.add(category.getCategoryBook());
        cat.add(category.getCategoryMedicine());
        category.getProduct();
        System.out.println(cat);
    }



    @Override
    public String toString() {
        return "Store{" +
                "cat=" + cat +
                '}';
    }
}