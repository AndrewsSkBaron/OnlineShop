package com.onlineShop.coherent.database;

import com.onlineShop.coherent.product.Product;

import java.sql.*;
import java.util.List;

public class DataBase {
    Connection worker = DBConnections.getConnection();

    public void createDataBaseTables() {
        try (Statement statement = worker.createStatement()){
            statement.execute("CREATE TABLE products(PRODUCT_NAME VARCHAR(150), RATE INT NOT NULL, PRICE INT NOT NULL, CATEGORY_NAME VARCHAR(56));");
            statement.execute("CREATE TABLE categories(CATEGORY_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,CATEGORY_NAME VARCHAR(56) REFERENCES products(CATEGORY_NAME));");
            statement.execute("CREATE TABLE orders(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, PRODUCT_NAME VARCHAR(150), PRICE INT NOT NULL);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropDataBaseTables()  {
        try (Statement statement = worker.createStatement()){
            statement.execute("DROP TABLE products;");
            statement.execute("DROP TABLE categories;");
            statement.execute("DROP TABLE orders;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTableOrders()  {
        try (Statement statement = worker.createStatement()){
            statement.execute("DELETE FROM orders;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dataInsertionTemplate(String name, int rate, int price, String category_name) {
        String sqlProducts = String.format("INSERT INTO products (product_name, rate, price, category_name) VALUES('%s', %d, %d, '%s');", name, rate, price, category_name);
        try (var preparedStatement = worker.prepareStatement(sqlProducts)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public void insertDataOfCategories() {
        try (Statement statement= worker.createStatement()) {
            statement.execute("INSERT INTO categories (category_name) VALUES(\"Book\")");
            statement.execute("INSERT INTO categories (category_name) VALUES(\"Beer\")");
            statement.execute("INSERT INTO categories (category_name) VALUES(\"Medicine\")");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getDataOutProducts(String category, List<Product> products) {
        try (Statement statement = worker.createStatement()) {
            String query = String.format("SELECT * FROM db_shop.products WHERE category_name = '%s'",category);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                rs.getString("category_name");
                products.add(new Product.Builder(rs.getString("product_name"), rs.getInt("rate"), rs.getInt("price")).build());
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProductsInOrderTable(Product product) {
        try(Statement statement = worker.createStatement()) {
            String sql = "INSERT INTO orders (product_name, price) VALUES(" + "'" + product.getName() + "'" + ", " + "'" + product.getPrice() + "'" +");";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}