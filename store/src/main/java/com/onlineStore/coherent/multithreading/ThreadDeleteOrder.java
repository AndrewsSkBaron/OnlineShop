package com.onlineStore.coherent.multithreading;

import com.onlineShop.coherent.product.Product;

import java.util.List;

public class ThreadDeleteOrder extends Thread {
    private List<Product> order;
    public ThreadDeleteOrder(List<Product> order) {
        this.order = order;
    }

    public void run() {
        while (Thread.currentThread().isAlive()) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().isInterrupted();
                break;
            }
            System.out.println(Thread.currentThread().isAlive());
            order.clear();
        }
    }
}