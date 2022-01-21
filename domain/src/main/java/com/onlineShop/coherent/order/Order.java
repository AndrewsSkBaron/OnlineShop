package com.onlineShop.coherent.order;

import com.onlineShop.coherent.product.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_order")
public class Order {
    @Transient
    private final String ORDER_URL = "http://localhost:8080/order";

    @Transient
    private final RestTemplate restTemplate = new RestTemplateBuilder().basicAuthentication("user", "user").build();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private int productPrice;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public void addProducts(Product product) {
        Order order = new Order();
        order.setProductPrice(product.getPrice());
        order.setProductName(product.getName());
        restTemplate.postForObject(ORDER_URL, order, Order.class);
    }

    public void deleteProducts() {
        restTemplate.delete(ORDER_URL);
    }

    //    @OneToMany
//    @Column(name = "purchased_products")
//    private List<Product> purchasedProducts = Collections.synchronizedList(new ArrayList<>());

//    @Transient
//    private List<Product> orderList = new ArrayList<>();
//
//    public Order(List<Product> orderList) {
//        this.orderList = orderList;
//    }
//
//    public Order() {
//    }
//
//    public synchronized void addGoods(List<Product> orderList) {
////        Order order = new Order();
////        orderList.addAll(orderList);
////        order.setPurchasedProducts(orderList);
////        restTemplate.postForObject(ORDER_URL, order, Order.class);
//    }
//
//    public List<Product> getPurchasedProducts() {
//        return purchasedProducts;
//    }
//
//    public void setPurchasedProducts(List<Product> purchasedProducts) {
//        this.purchasedProducts = purchasedProducts;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    @Override
//    public String toString() {
//        return "Order{" +
//                "id=" + id +
//                ", orderList=" + orderList +
//                '}';
//    }
}

