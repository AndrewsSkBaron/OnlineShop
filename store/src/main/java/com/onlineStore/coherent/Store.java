package com.onlineStore.coherent;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Category> categories;

    public Store(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "Store { " +
                "categories = " + '\n'+ categories + '\n' +" " +
                '}';
    }
}