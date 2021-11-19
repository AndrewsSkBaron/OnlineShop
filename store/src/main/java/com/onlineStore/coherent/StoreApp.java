package com.onlineStore.coherent;

public class StoreApp {
    public static void main(String[] args) {
        RandomStorePopulator random = new RandomStorePopulator();
        random.getRandomStore(3);
    }
}