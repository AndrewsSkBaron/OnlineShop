package com.onlineShop.coherent.category;

import com.onlineShop.coherent.product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categories", targetEntity = Product.class)
    private List<Product> listOfProducts;

    public Category(String name) {
        this.name = name;
        this.listOfProducts = new ArrayList<>();
    }

    public Category() {
        this.listOfProducts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", productList=" + listOfProducts +
                '}' + '\n';
    }
}
