package com.onlineStore.coherent.multithreading;


import database.DataBase;
import product.Product;

import java.util.List;

public class ThreadDeleteOrder extends Thread {
    private List<Product> order;
    DataBase dataBase = new DataBase();

    public ThreadDeleteOrder(List<Product> order) {
        this.order = order;
    }

    public void run() {
        while (Thread.currentThread().isAlive()) {
            try {
                sleep(60000);
            } catch (InterruptedException e) {
                Thread.currentThread().isInterrupted();
                break;
            }
            System.out.println(order);
            dataBase.deleteTableOrders();
            order.clear();
        }
    }
}