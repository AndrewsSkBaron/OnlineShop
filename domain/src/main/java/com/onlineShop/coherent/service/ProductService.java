package com.onlineShop.coherent.service;

import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.product.Product;
import com.onlineShop.coherent.repository.CategoryRepo;
import com.onlineShop.coherent.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo category;

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

/*
    public Product setCreateProduct(Product product, long categoryId) {
        Category category = categoryRepo.findById(categoryId).get();
        product.setCategories(category);
        return productRepo.save(product);
    }

    public Product SetCategory(long id) {
        Product product = productRepo.findById(id).get();
        product.setCategories(product.getCategories());
        return productRepo.save(product);
    }
    public Product save(Product product, long id) {
        Category category = categoryRepo.findById(id).get();
        product.setCategories(category);
        productRepo.save(product);
        return product;
    }
    */

}
