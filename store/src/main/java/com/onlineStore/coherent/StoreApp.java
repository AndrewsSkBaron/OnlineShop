package com.onlineStore.coherent;

import java.util.List;
import java.util.Map;

public class StoreApp {

    public static void main(String[] args) {
        Store store = RandomStorePopulator.getStore();
        Map<Category, List<Product>> catMap = store.getCategory();

        System.out.println(catMap.toString());

        System.out.println();

        for (Category category : catMap.keySet()) {
            System.out.println(category.toString() + " have");
            System.out.println();
            for (Product product : catMap.get(category)) {
                System.out.println("  " + product.toString());
                System.out.println();
            }
        }
    }
}