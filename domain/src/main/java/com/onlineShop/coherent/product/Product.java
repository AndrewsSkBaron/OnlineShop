package com.onlineShop.coherent.product;

import com.onlineShop.coherent.category.Category;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int rate;
    private int price;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Category categories;

    public Product(Builder builder) {
        this.name = builder.name;
        this.rate = builder.rate;
        this.price = builder.price;
        this.categories = builder.categories;
    }

    public Product() {
    }

    public Product(String name) {
        this.name = name;
        this.rate = 0;
        this.price = 0;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public java.lang.Long getId() {
        return id;
    }

    public int getRate() {
        return rate;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", price =" + price +
                        '\n';
    }

    public static class Builder {
        String name;
        int rate;
        int price;
        Category categories;

        public Builder (String name, int rate, int price, Category categories) {
            this.name = name;
            this.rate = rate;
            this.price = price;
            this.categories = categories;
        }

        public Product build() {
            return new Product(this);
        }
    }
}

