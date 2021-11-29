package category;

import product.Product;

import java.util.List;

public class Book extends Category {
    public Book(String categoryName, List<Product> listOfProducts) {
        super(categoryName, listOfProducts);
    }
}
