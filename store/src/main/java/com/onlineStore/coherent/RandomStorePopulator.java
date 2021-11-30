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
    Store store = new Store(categories);

    public Store getRandomStore() {

        Category book = new Book("Book", productsOfBooks);
        Category beer = new Beer("Beer",  productsOfBeers);
        Category medicine = new Medicine("Medicine",  productsOfMedicines);

//        for (int i = 0; i < 5; i++) {
//            productsOfBooks.add(new Product(faker.book().title(), faker.number().numberBetween(1, 10), faker.number().numberBetween(1, 1000)));
//            productsOfBeers.add(new Product(faker.beer().name(), faker.number().numberBetween(1, 10), faker.number().numberBetween(1, 1000)));
//            productsOfMedicines.add(new Product(faker.medical().medicineName(), faker.number().numberBetween(1, 10), faker.number().numberBetween(1, 1000)));
//        }

        productsOfBooks.add(new Product("Alo", 5, 895));
        productsOfBooks.add(new Product("Bsd", 1, 458));
        productsOfBooks.add(new Product("Cdb", 3, 478));
        productsOfBooks.add(new Product("Alo", 2, 789));
        productsOfBooks.add(new Product("Frg", 9, 628));

        productsOfBeers.add(new Product("Ght", 1, 854));
        productsOfBeers.add(new Product("Kil", 8, 591));
        productsOfBeers.add(new Product("Bnt", 10, 795));
        productsOfBeers.add(new Product("Gho", 7, 125));
        productsOfBeers.add(new Product("Otr", 5, 375));

        productsOfMedicines.add(new Product("Hfky", 1, 632));
        productsOfMedicines.add(new Product("Uyhn", 5, 475));
        productsOfMedicines.add(new Product("Web", 6, 730));
        productsOfMedicines.add(new Product("Alo", 3, 420));
        productsOfMedicines.add(new Product("Alo", 4, 420));
        productsOfMedicines.add(new Product("Dha", 3, 222));

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
