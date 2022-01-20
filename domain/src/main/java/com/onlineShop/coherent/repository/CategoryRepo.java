package com.onlineShop.coherent.repository;


import com.onlineShop.coherent.category.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
    Category findByName(String categoryName);
}
