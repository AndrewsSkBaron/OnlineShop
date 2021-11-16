package com.onlineStore.coherent;

import java.util.List;
import java.util.Map;

public class Store {
    private Map<Category, List<Product>> category;

    public Store(Map<Category, List<Product>> category) {
        this.category = category;
    }

    public Map<Category, List<Product>> getCategory() {
        return category;
    }
}
