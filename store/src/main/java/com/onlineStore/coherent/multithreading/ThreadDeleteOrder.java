package com.onlineStore.coherent.multithreading;

import com.onlineStore.coherent.order.Order;

import java.util.List;

public class ThreadDeleteOrder extends Thread {

    private List<Order> order;

    public ThreadDeleteOrder(List<Order> order) {
        this.order = order;
    }

    public void run() {
        if(!order.isEmpty()) {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            order.clear();
            System.out.println(order);
        }
    }
}
