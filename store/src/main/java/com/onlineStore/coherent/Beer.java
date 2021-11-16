package com.onlineStore.coherent;

import java.util.ArrayList;

public class Beer {
    ArrayList beer = new ArrayList<>();
    RandomStorePopulator faker = new RandomStorePopulator();

    public void putProductsInArray() {
        int[] array = new int[3];
        array[0] = 1;
        for (int i = 0; i < array.length; i++) {
            beer.add(new Product(faker.getRandomNameBeer(), faker.getRandomRate(), faker.getRandomPrice()));
        }
    }

    @Override
    public String toString() {
        return "Beer{" +
                "beer=" + beer +
                '}';
    }
}
