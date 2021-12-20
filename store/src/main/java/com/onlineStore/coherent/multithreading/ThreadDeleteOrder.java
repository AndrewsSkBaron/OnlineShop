package com.onlineStore.coherent.multithreading;

import product.Product;

import java.util.List;

public class ThreadDeleteOrder extends Thread {
    private List<Product> order;
    public ThreadDeleteOrder(List<Product> order) {
        this.order = order;
    }

    public void run() {
        while (Thread.currentThread().isInterrupted()) {
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().isInterrupted();
            }
            order.clear();
        }
    }
}