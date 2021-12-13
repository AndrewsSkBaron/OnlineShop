package com.onlineStore.coherent.multithreading;

import product.Product;

import java.util.List;

public class ThreadDeleteOrder extends Thread {
    private List<Product> order;
    public ThreadDeleteOrder(List<Product> order) {
        this.order = order;
    }
    public void run() {
        try {
            sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        order.clear();
        System.out.println(order);
    }
}