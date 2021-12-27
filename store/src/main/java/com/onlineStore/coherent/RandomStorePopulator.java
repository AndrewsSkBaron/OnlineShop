package com.onlineStore.coherent;

import category.Beer;
import category.Book;
import category.Category;
import category.Medicine;
import com.github.javafaker.Faker;
import database.DBWorker;
import product.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RandomStorePopulator {
    Faker faker = new Faker();

    List<Product> productsOfBooks = new ArrayList<>();
    List<Product> productsOfBeers = new ArrayList<>();
    List<Product> productsOfMedicines = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    Store store = Store.getStore(categories);

    DBWorker worker = new DBWorker();

    public void createTables() {
        try {
            Statement statement = worker.getConnection().createStatement();

            statement.execute("DROP TABLE dbstore.products;");
            statement.execute("DROP TABLE dbstore.categories;");

            statement.execute("CREATE TABLE products(PRODUCT_NAME VARCHAR(150), RATE INT NOT NULL, PRICE INT NOT NULL, CATEGORY_NAME VARCHAR(56));");
            statement.execute("CREATE TABLE categories(CATEGORY_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,CATEGORY_NAME VARCHAR(56) REFERENCES products(CATEGORY_NAME));");

            /*Book*/
            for (int i = 0; i < 3; i++) {
                String nameBook = faker.book().title();
                int rate = faker.number().numberBetween(1, 10);
                int price = faker.number().numberBetween(1, 1000);
                String category = "Book";
                String sqlBook = "INSERT INTO products (product_name, rate, price, category_name) VALUES(?, ?, ?, ?);";
                PreparedStatement preparedStatementBook = worker.getConnection().prepareStatement(sqlBook);
                preparedStatementBook.setString(1, nameBook);
                preparedStatementBook.setInt(2, rate);
                preparedStatementBook.setInt(3, price);
                preparedStatementBook.setString(4, category);
                preparedStatementBook.executeUpdate();
            }

            /*Beer*/
            for (int i = 0; i < 3; i++) {
                String nameBeer = faker.beer().name();
                int rate = faker.number().numberBetween(1, 10);
                int price = faker.number().numberBetween(1, 1000);
                String category = "Beer";
                String sqlBeer = "INSERT INTO products (product_name, rate, price, category_name) VALUES(?, ?, ?, ?);";
                PreparedStatement preparedStatementBeer = worker.getConnection().prepareStatement(sqlBeer);
                preparedStatementBeer.setString(1, nameBeer);
                preparedStatementBeer.setInt(2, rate);
                preparedStatementBeer.setInt(3, price);
                preparedStatementBeer.setString(4, category);
                preparedStatementBeer.executeUpdate();
            }

            /*Medicine*/
            for (int i = 0; i < 3; i++) {
                String nameMedicine = faker.medical().medicineName();
                int rate = faker.number().numberBetween(1, 10);
                int price = faker.number().numberBetween(1, 1000);
                String category = "Medicine";
                String sqlMedicine = "INSERT INTO products (product_name, rate, price, category_name) VALUES(?, ?, ?, ?);";
                PreparedStatement preparedStatementMedicine = worker.getConnection().prepareStatement(sqlMedicine);
                preparedStatementMedicine.setString(1, nameMedicine);
                preparedStatementMedicine.setInt(2, rate);
                preparedStatementMedicine.setInt(3, price);
                preparedStatementMedicine.setString(4, category);
                preparedStatementMedicine.executeUpdate();
            }

            statement.execute("INSERT INTO categories (category_name) VALUES(\"Book\")");
            statement.execute("INSERT INTO categories (category_name) VALUES(\"Beer\")");
            statement.execute("INSERT INTO categories (category_name) VALUES(\"Medicine\")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Store getRandomStore() {
        String queryBook = "SELECT * FROM products WHERE category_name = 'Book'";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(queryBook);
            String category = null;
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int rate = resultSet.getInt(2);
                int price = resultSet.getInt(3);
                category = resultSet.getString(4);
                productsOfBooks.add(new Product.Builder(name, rate, price).build());
            }
            Category book = new Book(category, productsOfBooks);
            categories.add(book);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String queryBeer = "SELECT * FROM products WHERE category_name = 'Beer'";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(queryBeer);
            String category = null;
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int rate = resultSet.getInt(2);
                int price = resultSet.getInt(3);
                category = resultSet.getString(4);
                productsOfBeers.add(new Product.Builder(name, rate, price).build());
            }
            Category beer = new Beer(category, productsOfBeers);
            categories.add(beer);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String queryMedicine = "SELECT * FROM products WHERE category_name = 'Medicine'";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(queryMedicine);
            String category = null;
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int rate = resultSet.getInt(2);
                int price = resultSet.getInt(3);
                category = resultSet.getString(4);
                productsOfMedicines.add(new Product.Builder(name, rate, price).build());
            }
            Category medicine = new Medicine(category, productsOfMedicines);
            categories.add(medicine);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return store;
    }
    public void printInfoOfStore() {
        System.out.println(store);
        for (Category category : categories) {
            System.out.println(category.getCategoryName() + " have");
            System.out.println();
            for (Product product : category.getListOfProducts()) {
                System.out.println("  " + product);
            }
        }
    }
}
