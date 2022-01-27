package com.onlineShop.coherent.service;


import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private final CategoryRepo categoryRepo;

    private boolean ifCategoryExist = true;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category save(Category category) {
        for (Category c : categoryRepo.findAll()) {
            if (c.getName().toLowerCase().equals(category.getName().toLowerCase())) {
                ifCategoryExist = false;
            }
        }
        if (ifCategoryExist) {
            categoryRepo.save(category);
        }
        return category;
    }

    public Category getOneCategory(java.lang.Long id) {
        Category category = categoryRepo.findById(id).get();
        if (category == null) {
            System.out.println("Category not found");
        } else {
            ifCategoryExist = true;
            categoryRepo.save(category);
        }
        return categoryRepo.save(category);
    }

    public List<Category> getCategory() {
        return (List<Category>) categoryRepo.findAll();
    }

}
