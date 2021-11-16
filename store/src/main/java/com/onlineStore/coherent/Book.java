package com.onlineStore.coherent;

import java.util.ArrayList;

public class Book {
    ArrayList book = new ArrayList<>();
    RandomStorePopulator faker = new RandomStorePopulator();

    public void putProductsInArray() {
        int[] array = new int[3];
        array[0] = 1;
        for (int i = 0; i < array.length; i++) {
            book.add(new Product(faker.getRandomNameBook(), faker.getRandomRate(), faker.getRandomPrice()));
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "book=" + book +
                '}';
    }
}
