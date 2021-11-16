package com.onlineStore.coherent;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RandomStorePopulator {
    public static Store getStore() {
    Faker faker = new Faker();
    Map<Category, List<Product>> categoryMap = new HashMap<>();


    //Category Beer
    categoryMap.put(new Category("Beer"), Arrays.asList(
            new Product(faker.beer().name(), faker.number().numberBetween(1, 10), faker.number().numberBetween(100, 1500)),
            new Product(faker.beer().name(), faker.number().numberBetween(1, 10), faker.number().numberBetween(100, 1500)),
            new Product(faker.beer().name(),  faker.number().numberBetween(1, 10), faker.number().numberBetween(100, 1500))
    ));

    //Category Book
    categoryMap.put(new Category("Book"), Arrays.asList(
            new Product(faker.book().title(),  faker.number().numberBetween(1, 10), faker.number().numberBetween(100, 1500)),
            new Product(faker.book().title(),  faker.number().numberBetween(1, 10), faker.number().numberBetween(100, 1500)),
            new Product(faker.book().title(),  faker.number().numberBetween(1, 10), faker.number().numberBetween(100, 1500))
    ));

    //Category Medicine
    categoryMap.put(new Category("Medicine"), Arrays.asList(
            new Product(faker.medical().medicineName(), faker.number().numberBetween(1, 10), faker.number().numberBetween(100, 1500)),
            new Product(faker.medical().medicineName(), faker.number().numberBetween(1, 10), faker.number().numberBetween(100, 1500)),
            new Product(faker.medical().medicineName(), faker.number().numberBetween(1, 10), faker.number().numberBetween(100, 1500))
    ));

/*          System.out.println("personMap: " + categoryMap.toString());
            System.out.println();
            System.out.println("personMap.keySet(): " + categoryMap.keySet().toString());
            System.out.println();
        for(Category category : categoryMap.keySet()){
                System.out.println(category.toString() + " имеет");
                System.out.println();
            for (Product product : categoryMap.get(category)){
                    System.out.println("  " + product.toString());
                    System.out.println();
            }
        }*/
    Store store = new Store(categoryMap);

    return store;
}
}