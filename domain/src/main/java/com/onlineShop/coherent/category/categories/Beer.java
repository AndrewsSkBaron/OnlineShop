package com.onlineShop.coherent.category.categories;

import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.product.Product;

import java.util.List;

public class Beer extends Category {
    public Beer(String name) {
        super(name);
    }

    public Beer(List<Product> listOfProducts) {
        super(listOfProducts);
    }
}
