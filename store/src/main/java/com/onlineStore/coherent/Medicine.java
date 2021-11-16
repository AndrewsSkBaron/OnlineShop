package com.onlineStore.coherent;

import java.util.ArrayList;

public class Medicine {
    ArrayList medicine = new ArrayList<>();
    RandomStorePopulator faker = new RandomStorePopulator();

    public void putProductsInArray() {
        int[] array = new int[3];
        array[0] = 1;
        for (int i = 0; i < array.length; i++) {
            medicine.add(new Product(faker.getRandomNameMedicine(), faker.getRandomRate(), faker.getRandomPrice()));
        }
    }


    @Override
    public String toString() {
        return "Medicine{" +
                "medicine=" + medicine +
                '}';
    }
}
