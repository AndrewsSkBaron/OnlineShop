package com.onlineShop.coherent.category.categories;

import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.product.Product;

import java.util.List;

public class Book extends Category {
    public Book(String name) {
        super(name);
    }

    public Book(List<Product> listOfProducts) {
        super(listOfProducts);
    }
}
