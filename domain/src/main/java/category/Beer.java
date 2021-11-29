package category;

import product.Product;

import java.util.List;

public class Beer extends Category{
    public Beer(String categoryName, List<Product> listOfProducts) {
        super(categoryName, listOfProducts);
    }
}
