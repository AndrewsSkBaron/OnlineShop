package com.onlineStore.coherent;

import com.github.javafaker.Faker;

public class Random {

    private final Faker faker = new Faker();

    public int getRate() {
        return faker.number().randomDigitNotZero();
    }

    public int getPrice() {
        return faker.number().numberBetween(1, 1000);
    }

    public String getProductName(String categoryName) {

        return switch (categoryName) {
            case "Book" -> faker.book().title();
            case "Beer" -> faker.beer().name();
            case "Medicine" -> faker.medical().medicineName();
            default -> "not found product";
        };
    }
}
