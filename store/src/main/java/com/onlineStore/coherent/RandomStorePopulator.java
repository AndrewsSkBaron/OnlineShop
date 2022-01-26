package com.onlineStore.coherent;

import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.client.HttpClient;
import com.onlineShop.coherent.product.Product;
import org.reflections.Reflections;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

import static org.reflections.scanners.Scanners.SubTypes;

@Component
public class RandomStorePopulator {

    private final Random popular = new Random();
    HttpClient httpClient = new HttpClient();

    Reflections reflections = new Reflections("com.onlineShop.coherent.category.categories");
    Set<Class<?>> subTypes = reflections.get(SubTypes.of(Category.class).asClass());
    public void insertDataOfProducts() {
        for (Class c : subTypes) {
            String s = c.getName().replace("com.onlineShop.coherent.category.categories.", "");
            httpClient.getRestTemplate().postForObject(httpClient.getURL() + "/category", new Category(s), Category.class);
        }
        ResponseEntity<Category[]> responseCategory =  httpClient.getRestTemplate().getForEntity(httpClient.getURL() + "/category", Category[].class);
        for (Category category : Objects.requireNonNull(responseCategory.getBody())) {
            for (int i = 0; i < 3; i++) {
                Product product = new Product.Builder(popular.getProductName(category.getName()), popular.getRate(), popular.getPrice(), category).build();
                httpClient.getRestTemplate().postForObject(httpClient.getURL() + "/product", product, Product.class);
            }
        }
    }


    public Store getRandomStore() {
        ResponseEntity<Product[]> responseProduct =  httpClient.getRestTemplate().getForEntity(httpClient.getURL() + "/product", Product[].class);
        List<Category> categories = new ArrayList<>();
        List<Product> productsOfBooks = new ArrayList<>();
        List<Product> productsOfBeers = new ArrayList<>();
        List<Product> productsOfMedicines = new ArrayList<>();

        for (Product product : Objects.requireNonNull(responseProduct.getBody())) {
            if (product.getCategories().getName().equals("Book")) {
                productsOfBooks.add(product);
            } else if (product.getCategories().getName().equals("Beer")) {
                productsOfBeers.add(product);
            } else if (product.getCategories().getName().equals("Medicine")) {
                productsOfMedicines.add(product);
            } else {
                break;
            }
        }

        categories.add(new Category(productsOfBeers));
        categories.add(new Category(productsOfBooks));
        categories.add(new Category(productsOfMedicines));

        return Store.getStore(categories);
    }
}
