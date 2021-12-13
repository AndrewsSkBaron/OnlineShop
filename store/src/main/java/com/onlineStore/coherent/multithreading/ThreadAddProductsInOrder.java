package com.onlineStore.coherent.multithreading;

import product.Product;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ThreadAddProductsInOrder extends Thread {
    private static ThreadAddProductsInOrder threadAddProducts;
    List<Product> productsToOrder;
    Product product;

    private ThreadAddProductsInOrder(List<Product> productsToOrder, Product product) {
        this.productsToOrder = productsToOrder;
        this.product = product;
    }

    public static synchronized ThreadAddProductsInOrder getInstance(List<Product> productsToOrder, Product product) {
        if (threadAddProducts == null) {
            threadAddProducts = new ThreadAddProductsInOrder(productsToOrder, product);
        }
        return  threadAddProducts;
    }

    public void run() {
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