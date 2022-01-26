package com.onlineShop.coherent.category.categories;

import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.product.Product;

import java.util.List;

public class Medicine extends Category {
    public Medicine(String name) {
        super(name);
    }

    public Medicine(List<Product> listOfProducts) {
        super(listOfProducts);
    }
}
