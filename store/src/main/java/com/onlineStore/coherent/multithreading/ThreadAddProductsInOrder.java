package com.onlineStore.coherent.multithreading;


import com.onlineShop.coherent.product.Product;
import com.onlineShop.coherent.client.HttpClient;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadAddProductsInOrder extends Thread {
    Product product;
    HttpClient httpClient = new HttpClient();

    public ThreadAddProductsInOrder(List<Product> productsToOrder, Product product) {
        this.product = product;
    }

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(numberForSetTimeOut());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        httpClient.addOrder(product);
    }

    //генерирует случайное целое число от 1 до 30
    public int numberForSetTimeOut() {
        int number = (int) (1 + Math.random() * 30);
        return number;
    }
}