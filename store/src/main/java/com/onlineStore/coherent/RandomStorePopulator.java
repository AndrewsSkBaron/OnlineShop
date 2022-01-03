package com.onlineStore.coherent;

import category.Beer;
import category.Book;
import category.Category;
import category.Medicine;

import database.DBConnections;
import product.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RandomStorePopulator {
    List<Product> productsOfBooks = new ArrayList<>();
    List<Product> productsOfBeers = new ArrayList<>();
    List<Product> productsOfMedicines = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    Store store = Store.getStore(categories);

    public Store getRandomStore() {
        DBConnections worker = new DBConnections();
        /*Book*/
        try (Statement statement = worker.getConnection().createStatement()) {
            String query = "SELECT * FROM db_shop.products WHERE category_name = 'Book'";
            ResultSet rs = statement.executeQuery(query);

            String category = null;
            while (rs.next()) {
                category = rs.getString("category_name");
                productsOfBooks.add(new Product.Builder(rs.getString("product_name"), rs.getInt("rate"), rs.getInt("price")).build());
            }
            Category book = new Book(category, productsOfBooks);
            categories.add(book);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*Beer*/
        try (Statement statement = worker.getConnection().createStatement()) {
            String query = "SELECT * FROM db_shop.products WHERE category_name = 'Beer'";
            ResultSet rs = statement.executeQuery(query);
            String category = null;
            while (rs.next()) {
                category = rs.getString("category_name");
                productsOfBeers.add(new Product.Builder(rs.getString("product_name"), rs.getInt("rate"), rs.getInt("price")).build());
            }
            Category beer = new Beer(category, productsOfBeers);
            categories.add(beer);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*Medicine*/
        try (Statement statement = worker.getConnection().createStatement()) {
            String query = "SELECT * FROM db_shop.products WHERE category_name = 'Medicine'";
            ResultSet rs = statement.executeQuery(query);
            String category = null;
            while (rs.next()) {
                category = rs.getString("category_name");
                productsOfMedicines.add(new Product.Builder(rs.getString("product_name"), rs.getInt("rate"), rs.getInt("price")).build());
            }
            Category medicine = new Medicine(category, productsOfMedicines);
            categories.add(medicine);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return store;
    }
}
