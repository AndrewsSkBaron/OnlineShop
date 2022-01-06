package com.onlineStore.coherent;

import category.Beer;
import category.Book;
import category.Category;
import category.Medicine;

import com.github.javafaker.Faker;
import database.DataBase;
import product.Product;

import java.util.ArrayList;
import java.util.List;

public class RandomStorePopulator {
    DataBase dataBase = new DataBase();
    Faker faker = new Faker();
    List<Product> productsOfBooks = new ArrayList<>();
    List<Product> productsOfBeers = new ArrayList<>();
    List<Product> productsOfMedicines = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    Store store = Store.getStore(categories);

    public void insertDataOfProducts() {
        for (int i = 0; i < 3; i++) {
            dataBase.dataInsertionTemplate(faker.book().title(), faker.number().numberBetween(1, 10), faker.number().numberBetween(1, 1000),"Book");
            dataBase.dataInsertionTemplate(faker.beer().name(), faker.number().numberBetween(1, 10), faker.number().numberBetween(1, 1000),"Beer");
            dataBase.dataInsertionTemplate(faker.medical().medicineName(), faker.number().numberBetween(1, 10), faker.number().numberBetween(1, 1000),"Medicine");
        }
    }

    public Store getRandomStore() {
        Category book = new Book("Book", productsOfBooks);
        Category beer = new Beer("Beer",  productsOfBeers);
        Category medicine = new Medicine("Medicine",  productsOfMedicines);

        dataBase.getDataOutProducts("Book", productsOfBooks);
        dataBase.getDataOutProducts("Beer", productsOfBeers);
        dataBase.getDataOutProducts("Medicine", productsOfMedicines);

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
