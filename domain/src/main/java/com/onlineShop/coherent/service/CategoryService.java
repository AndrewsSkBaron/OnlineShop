package com.onlineShop.coherent.service;


import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.product.Product;
import com.onlineShop.coherent.repository.CategoryRepo;
import com.onlineShop.coherent.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private final CategoryRepo categoryRepo;
    @Autowired
    private final ProductRepo productRepo;
    private boolean ifCategoryExist = true;

    public CategoryService(CategoryRepo categoryRepo, ProductRepo productRepo) {
        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
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

    public Category getOneCategory(Long id) {
        Category category = categoryRepo.findById(id).get();
        if (category == null) {
            System.out.println("Category not found");
        } else {
            ifCategoryExist = true;
            categoryRepo.save(category);
        }
        return categoryRepo.save(category);
    }

    public Category addProductToCategory(Category category) {
        Category updateCategory = categoryRepo.findByName(category.getName());
        List<Product> productList = new ArrayList<>();
        for (Product product : category.getListOfProducts()) {
            Product productFromDb = null;
            try {
                productFromDb = productRepo.findByName(product.getName());
            } catch (Exception e) {
                List<Product> tmp = productRepo.searchDuplicateByName(product.getName());
                for (Product p : tmp) {
                    if (product.equals(p))
                        productList.add(p);
                }
            }
            if (productFromDb != null) {
                productList.add(productFromDb);
            }
        }
        updateCategory.addProduct(productList);
        categoryRepo.save(updateCategory);
        return updateCategory;
    }

    public List<Category> getCategory() {
        return (List<Category>) categoryRepo.findAll();
    }

}
