package com.onlineShop.coherent.service;

import com.onlineShop.coherent.product.Product;
import com.onlineShop.coherent.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product) {
        productRepo.save(product);
        return product;
    }

    public List<Product> getProduct() {
        return (List<Product>) productRepo.findAll();
    }

    public Product getProduct(Long id) {
        Product product = productRepo.findById(id).get();
        return productRepo.save(product);
    }

}
