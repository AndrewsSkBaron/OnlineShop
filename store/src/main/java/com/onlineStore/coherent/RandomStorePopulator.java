package com.onlineStore.coherent;

import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.product.Product;
import org.reflections.Reflections;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.reflections.scanners.Scanners.SubTypes;

@Component
public class RandomStorePopulator {
    private final String URL = "http://localhost:8080";
    private final Random popular = new Random();
    private final RestTemplate restTemplate = new RestTemplateBuilder().basicAuthentication("user", "user").build();

    public void insertDataOfProducts() {
        Reflections reflections = new Reflections("com.onlineShop.coherent.category.categories");
        Set<Class<?>> subTypes = reflections.get(SubTypes.of(Category.class).asClass());
        for (Class c : subTypes) {
            String s = c.getName().replace("com.onlineShop.coherent.category.categories.", "");
            restTemplate.postForObject(URL + "/category", new Category(s), Category.class);
        }
        ResponseEntity<Category[]> responseCategory = restTemplate.getForEntity(URL + "/category", Category[].class);
        for (Category category : Objects.requireNonNull(responseCategory.getBody())) {
            for (int i = 0; i < 3; i++) {
                Product product = new Product.Builder(popular.getProductName(category.getName()), popular.getRate(), popular.getPrice(), category.getId()).build();
                restTemplate.postForObject(URL + "/product", product, Product.class);
            }
        }
    }

    List<Category> categories = new ArrayList<>();
    Store store = Store.getStore(categories);
    public Store getRandomStore() {
        ResponseEntity<Category[]> responseCategory = restTemplate.getForEntity(URL + "/category", Category[].class);
        for (Category category : Objects.requireNonNull(responseCategory.getBody())) {
            List<Product> products = new ArrayList<>();
            ResponseEntity<Product[]> responseProduct = restTemplate.getForEntity(URL + "/product", Product[].class);
            for (Product product : Objects.requireNonNull(responseProduct.getBody())) {
                products.add(product);
            }
            categories.add(category);
        }
        return store;
    }
}
