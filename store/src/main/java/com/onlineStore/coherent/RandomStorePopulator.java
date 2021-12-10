package com.onlineStore.coherent;

import category.Beer;
import category.Book;
import category.Category;
import category.Medicine;
import com.github.javafaker.Faker;
import product.Product;

import java.util.ArrayList;
import java.util.List;

public class RandomStorePopulator {
    Faker faker = new Faker();
    List<Product> productsOfBooks = new ArrayList<>();
    List<Product> productsOfBeers = new ArrayList<>();
    List<Product> productsOfMedicines = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    Store store = Store.getStore(categories);

    public Store getRandomStore() {
        Category book = new Book("Book", productsOfBooks);
        Category beer = new Beer("Beer",  productsOfBeers);
        Category medicine = new Medicine("Medicine",  productsOfMedicines);
        for (int i = 0; i < 3; i++) {
            productsOfBooks.add(new Product.Builder((long)(11 + Math.random() * 100), faker.book().title(), faker.number().numberBetween(1, 10), faker.number().numberBetween(1, 1000)).build());
            productsOfBeers.add(new Product.Builder((long)(11 + Math.random() * 100), faker.beer().name(), faker.number().numberBetween(1, 10), faker.number().numberBetween(1, 1000)).build());
            productsOfMedicines.add(new Product.Builder((long)(11 + Math.random() * 100), faker.medical().medicineName(), faker.number().numberBetween(1, 10), faker.number().numberBetween(1, 1000)).build());
        }
        categories.add(book);
        categories.add(beer);
        categories.add(medicine);

        return store;
    }

    public void printInfoOfStore() {
        System.out.println(store);
        for (Category category : categories) {
            System.out.println(category.getCategoryName() + " have");
            System.out.println();
            for (Product product : category.getListOfProducts()) {
                System.out.println("  " + product);
            }
        }
    }
}
