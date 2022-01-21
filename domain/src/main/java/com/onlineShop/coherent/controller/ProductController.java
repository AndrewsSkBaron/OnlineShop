package com.onlineShop.coherent.controller;


import com.onlineShop.coherent.product.Product;
import com.onlineShop.coherent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ResponseEntity getProducts() {
        return ResponseEntity.ok(productService.getProduct());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product p = productService.save(product);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }
}
