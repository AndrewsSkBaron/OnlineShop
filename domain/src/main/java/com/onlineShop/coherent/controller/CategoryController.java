package com.onlineShop.coherent.controller;

import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class CategoryController {
    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity getCategories() {
        return ResponseEntity.ok(categoryService.getCategory());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity getCategoryById(@PathVariable java.lang.Long id) {
        return ResponseEntity.ok(categoryService.getOneCategory(id));
    }

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category cat = categoryService.save(category);
        return new ResponseEntity<>(cat, HttpStatus.CREATED);
    }
}
