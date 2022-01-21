package com.onlineStore.coherent;

import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.product.Product;
import org.reflections.Reflections;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;

@Component
public class RandomStorePopulator {
    private final String CATEGORY_URL = "http://localhost:8080/category";
    private final String PRODUCT_URL = "http://localhost:8080/product";
    private final String CATEGORY_PUT_URL = "http://localhost:8080/category/{id}";
    private final Random popular = new Random();
    private final RestTemplate restTemplate = new RestTemplateBuilder().basicAuthentication("user", "user").build();

    List<Product> products = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    Store store = Store.getStore(categories);

    public void insertDataOfProducts() {
        Reflections reflections = new Reflections("com.onlineShop.coherent.category.categories");
        Set<Class<?>> subTypes = reflections.get(SubTypes.of(Category.class).asClass());
        for (Class c : subTypes) {
            String s = c.getName().replace("com.onlineShop.coherent.category.categories.", "");
            restTemplate.postForObject(CATEGORY_URL, new Category(s), Category.class);
        }
        ResponseEntity<Category[]> responseCategory = restTemplate.getForEntity(CATEGORY_URL, Category[].class);
        for (Category category : Objects.requireNonNull(responseCategory.getBody())) {
            List<Product> productList = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Product product = new Product.Builder(popular.getProductName(category.getName()), popular.getRate(), popular.getPrice()).build();
                restTemplate.postForObject(PRODUCT_URL, product, Product.class);
                productList.add(product);
            }
            category.addProduct(productList);
            restTemplate.put(CATEGORY_PUT_URL, category, Category.class);
        }
    }

    public Store getRandomStore() {
        ResponseEntity<Category[]> responseCategory = restTemplate.getForEntity(CATEGORY_URL, Category[].class);
        for (Category category : Objects.requireNonNull(responseCategory.getBody())) {
            categories.add(category);
            products.addAll(category.getListOfProducts());
        }
        return store;
    }
}
