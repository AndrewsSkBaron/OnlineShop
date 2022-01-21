package com.onlineShop.coherent.repository;


import com.onlineShop.coherent.product.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

    Product findByName(String name);

    @Query(value = "SELECT * FROM product WHERE name = :name", nativeQuery = true)
    List<Product> searchDuplicateByName(String name);

}
