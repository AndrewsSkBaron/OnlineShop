package com.onlineStore.coherent.multithreading;

import com.onlineShop.coherent.order.Order;
import com.onlineShop.coherent.product.Product;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadAddProductsInOrder extends Thread {
    List<Product> productsToOrder;
    Product product;
    Order order = new Order();

    public ThreadAddProductsInOrder(List<Product> productsToOrder, Product product) {
        this.productsToOrder = productsToOrder;
        this.product = product;
    }

    public void run() {
        order.addProducts(product);
        try {
            TimeUnit.SECONDS.sleep(numberForSetTimeOut());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productsToOrder.add(product);
    }

    //генерирует случайное целое число от 1 до 30
    public int numberForSetTimeOut() {
        int number = (int) (1 + Math.random() * 30);
        return number;
    }
}