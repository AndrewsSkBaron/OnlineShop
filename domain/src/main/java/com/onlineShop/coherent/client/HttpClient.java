package com.onlineShop.coherent.client;

import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.order.Order;
import com.onlineShop.coherent.product.Product;
import org.reflections.Reflections;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.reflections.scanners.Scanners.SubTypes;


public class HttpClient {
    private final String URL = "http://localhost:8080";
    Random popular = new Random();

    Reflections reflections = new Reflections("com.onlineShop.coherent.category.categories");
    Set<Class<?>> subTypes = reflections.get(SubTypes.of(Category.class).asClass());

    RestTemplate restTemplate = new RestTemplateBuilder().basicAuthentication("user", "user").build();


    private List<Product> listOfProducts;

    public void insertDataOfProducts() {

        for (Class c : subTypes) {
            String s = c.getName().replace("com.onlineShop.coherent.category.categories.", "");
            restTemplate.postForObject(URL + "/category", new Category(s), Category.class);
        }
        ResponseEntity<Category[]> responseCategory =  restTemplate.getForEntity(URL + "/category", Category[].class);
        for (Category category : Objects.requireNonNull(responseCategory.getBody())) {
            for (int i = 0; i < 3; i++) {
                Product product = new Product.Builder(popular.getProductName(category.getName()), popular.getRate(), popular.getPrice(), category).build();
                restTemplate.postForObject(URL + "/product", product, Product.class);
            }
        }
    }
    public Product[] getDataOfProducts() {
        ResponseEntity<Product[]> responseProduct = restTemplate.getForEntity(URL + "/product", Product[].class);
        return responseProduct.getBody();
    }

    public Order addProductsToOrder(Product product) {
        Order order = new Order();
        order.setProductPrice(product.getPrice());
        order.setProductName(product.getName());
        restTemplate.postForObject(URL + "/order", order, Order.class);
        return order;
    }

    public void deleteProducts() {
        restTemplate.delete(URL + "/order");
    }

    public void addProduct(List<Product> products) {
        if (listOfProducts == null) {
            listOfProducts = new ArrayList<>();
        }
        listOfProducts.addAll(products);
    }

    public void printProducts() {
        for (Product product : listOfProducts) {
            System.out.println(product);
        }
    }

}
