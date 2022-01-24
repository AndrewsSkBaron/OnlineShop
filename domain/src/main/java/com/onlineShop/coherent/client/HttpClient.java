package com.onlineShop.coherent.client;

import com.onlineShop.coherent.order.Order;
import com.onlineShop.coherent.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class HttpClient {
    String URL = "http://localhost:8080";
    RestTemplate restTemplate = new RestTemplateBuilder().basicAuthentication("user", "user").build();

    private List<Product> listOfProducts;

    public String getURL() {
        return URL;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
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
