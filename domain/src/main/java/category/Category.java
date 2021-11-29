package category;

import product.Product;

import java.util.List;

public class Category {
    private String categoryName;
    private List<Product> listOfProducts;

    public Category(String categoryName, List<Product> listOfProducts) {
        this.categoryName = categoryName;
        this.listOfProducts = listOfProducts;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    @Override
    public String toString() {
        return "Category { " +
                "categoryName=' " + categoryName + '\'' +
                ", listOfProducts = " + '\n' + "   "+ listOfProducts + '\n' +
                '}';
    }
}
