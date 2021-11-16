package com.onlineStore.coherent;

import com.github.javafaker.Faker;

public class RandomStorePopulator {
    private String randomNameBeer;
    private String randomNameBook;
    private String randomNameMedicine;
    private int randomRate;
    private int randomPrice;

    Faker faker = new Faker();

    public String getRandomNameBeer() {
        randomNameBeer = faker.beer().name();
        return randomNameBeer;
    }

    public String getRandomNameBook() {
        randomNameBook = faker.book().title();
        return randomNameBook;
    }

    public String getRandomNameMedicine() {
        randomNameMedicine = faker.medical().medicineName();
        return randomNameMedicine;
    }

    public int getRandomRate() {
        randomRate = faker.number().numberBetween(1, 10);
        return randomRate;
    }

    public int getRandomPrice() {
        randomPrice = faker.number().numberBetween(100, 1500);
        return randomPrice;
    }
}
