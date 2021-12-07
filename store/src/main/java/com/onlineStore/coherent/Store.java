package com.onlineStore.coherent;

import category.Category;

import java.util.List;

public class Store {
    private static Store store;
    private List<Category> categories;

    public static Store getStore(List<Category> categories) {
        if (store == null) {
            store = new Store(categories);
        }
        return store;
    }

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


//public class Store {
//    private List<Category> categories;
//
//    public Store(List<Category> categories) {
//        this.categories = categories;
//    }
//
//    public List<Category> getCategories() {
//        return categories;
//    }
//
//    @Override
//    public String toString() {
//        return "Store { " +
//                "categories = " + '\n'+ categories + '\n' +" " +
//                '}';
//    }
//}