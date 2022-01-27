package com.onlineShop.coherent.client;

import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.order.Order;
import com.onlineShop.coherent.product.Product;
import org.reflections.Reflections;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;


public class HttpClient {
    private final String URL = "http://localhost:8080";
    RestTemplate restTemplate = new RestTemplateBuilder().basicAuthentication("user", "user").build();
    Reflections reflections = new Reflections("com.onlineShop.coherent.category.categories");
    Set<Class<?>> subTypes = reflections.get(SubTypes.of(Category.class).asClass());

    public void postCategory() {
        for (Class c : subTypes) {
            String s = c.getName().replace("com.onlineShop.coherent.category.categories.", "");
            restTemplate.postForObject(URL + "/category", new Category(s), Category.class);
        }
    }

    public void postProduct(Product product) {
        restTemplate.postForObject(URL + "/product", product, Product.class);
    }

    public Category[] getDataOfCategory() {
        ResponseEntity<Category[]> responseCategory =  restTemplate.getForEntity(URL + "/category", Category[].class);
        return responseCategory.getBody();
    }

    public Product[] getDataOfProducts() {
        ResponseEntity<Product[]> responseProduct = restTemplate.getForEntity(URL + "/product", Product[].class);
        return responseProduct.getBody();
    }

    public Order addOrder(Product product) {
        Order order = new Order();
        order.setProductPrice(product.getPrice());
        order.setProductName(product.getName());
        restTemplate.postForObject(URL + "/order", order, Order.class);
        return order;
    }

    public void deleteOrder() {
        restTemplate.delete(URL + "/order");
    }

}
