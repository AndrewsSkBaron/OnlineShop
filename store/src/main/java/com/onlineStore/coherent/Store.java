package com.onlineStore.coherent;

import category.Category;

import java.util.List;

public class Store {
    private static Store store;
    private List<Category> categories;

    private Store(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public static Store getStore(List<Category> categories) {
        if (store == null) {
            store = new Store(categories);
        }
        return store;
    }

    @Override
    public String toString() {
        return "Store { " +
                "categories = " + '\n'+ categories + '\n' +" " +
                '}';
    }
}