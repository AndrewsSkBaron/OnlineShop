package category;

import product.Product;

import java.util.List;

public class Medicine extends Category {
    public Medicine(String categoryName, List<Product> listOfProducts) {
        super(categoryName, listOfProducts);
    }
}
