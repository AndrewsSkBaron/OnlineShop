package com.onlineStore.coherent.model;

public class Root {
    private Sort sort;

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Root{" +
                "sort=" + sort +
                '}';
    }
}
