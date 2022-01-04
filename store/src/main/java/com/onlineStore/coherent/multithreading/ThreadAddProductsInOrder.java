package com.onlineStore.coherent.multithreading;

import database.DataBase;
import product.Product;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadAddProductsInOrder extends Thread {
    List<Product> productsToOrder;
    Product product;
    DataBase dataBase = new DataBase();

    public ThreadAddProductsInOrder(List<Product> productsToOrder, Product product) {
        this.productsToOrder = productsToOrder;
        this.product = product;
    }

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(numberForSetTimeOut());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productsToOrder.add(product);
        dataBase.addProductsInOrderTable(product);
        System.out.println(productsToOrder);
    }

    //генерирует случайное целое число от 1 до 30
    public int numberForSetTimeOut() {
        int number = (int) (1 + Math.random() * 30);
        return number;
    }
}