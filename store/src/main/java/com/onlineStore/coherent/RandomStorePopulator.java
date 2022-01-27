package com.onlineStore.coherent;

import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.client.HttpClient;
import com.onlineShop.coherent.product.Product;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class RandomStorePopulator {
    HttpClient httpClient = new HttpClient();

    public Store getRandomStore() {
        httpClient.insertDataOfProducts();

        List<Category> categories = new ArrayList<>();
        List<Product> productsOfBooks = new ArrayList<>();
        List<Product> productsOfBeers = new ArrayList<>();
        List<Product> productsOfMedicines = new ArrayList<>();

        for (Product product : Objects.requireNonNull(httpClient.getDataOfProducts())) {
            if (product.getCategories().getName().equals("Book")) {
                productsOfBooks.add(product);
            } else if (product.getCategories().getName().equals("Beer")) {
                productsOfBeers.add(product);
            } else if (product.getCategories().getName().equals("Medicine")) {
                productsOfMedicines.add(product);
            } else {
                break;
            }
        }

        categories.add(new Category(productsOfBeers));
        categories.add(new Category(productsOfBooks));
        categories.add(new Category(productsOfMedicines));

        return Store.getStore(categories);
    }
}
