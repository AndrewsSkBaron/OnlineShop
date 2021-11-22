package com.onlineStore.coherent;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class RandomStorePopulator {
    Faker faker = new Faker();
    List<Product> productsOfBooks = new ArrayList<>();
    List<Product> productsOfBeers = new ArrayList<>();
    List<Product> productsOfMedicines = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    Store store = new Store(categories);

    public Store getRandomStore(int count) {

        Category book = new Book("Book", productsOfBooks);
        Category beer = new Beer("Beer",  productsOfBeers);
        Category medicine = new Medicine("Medicine",  productsOfMedicines);

        for (int i = 0; i < count; i++) {
            productsOfBooks.add(new Product(faker.book().title(), faker.number().numberBetween(1, 10), faker.number().numberBetween(1, 1000)));
            productsOfBeers.add(new Product(faker.beer().name(), faker.number().numberBetween(1, 10), faker.number().numberBetween(1, 1000)));
            productsOfMedicines.add(new Product(faker.medical().medicineName(), faker.number().numberBetween(1, 10), faker.number().numberBetween(1, 1000)));
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
                System.out.println();
            }
        }
    }
}
