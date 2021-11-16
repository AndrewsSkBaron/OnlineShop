package com.onlineStore.coherent;

public class Category {
    private String categoryName;
    private Book book = new Book();
    private Beer beer = new Beer();
    private Medicine medicine = new Medicine();


    public String getCategoryBear() {
        categoryName = "Beer";
        return categoryName;
    }
    public String getCategoryBook() {
        categoryName = "Book";
        return categoryName;
    }
    public String getCategoryMedicine() {
        categoryName = "Medicine";
        return categoryName;
    }

    public void getProduct() {
        book.putProductsInArray();
        beer.putProductsInArray();
        medicine.putProductsInArray();

        System.out.println(book);
        System.out.println(beer);
        System.out.println(medicine);
    }
}
