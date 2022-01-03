package database;

import com.github.javafaker.Faker;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBFill {
    Faker faker = new Faker();
    DBConnections worker = new DBConnections();
    public void insertData() {
        String SQL_Products = "INSERT INTO products (product_name, rate, price, category_name) VALUES(?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = worker.getConnection().prepareStatement(SQL_Products)) {
            for (int i = 0; i < 3; i++) {
                preparedStatement.setString(1, faker.book().title());
                preparedStatement.setInt(2, faker.number().numberBetween(1, 10));
                preparedStatement.setInt(3, faker.number().numberBetween(1, 1000));
                preparedStatement.setString(4, "Book");
                preparedStatement.addBatch();
            }
            for (int i = 0; i < 3; i++) {
                preparedStatement.setString(1, faker.beer().name());
                preparedStatement.setInt(2, faker.number().numberBetween(1, 10));
                preparedStatement.setInt(3, faker.number().numberBetween(1, 1000));
                preparedStatement.setString(4, "Beer");
                preparedStatement.addBatch();
            }
            for (int i = 0; i < 3; i++) {
                preparedStatement.setString(1, faker.medical().medicineName());
                preparedStatement.setInt(2, faker.number().numberBetween(1, 10));
                preparedStatement.setInt(3, faker.number().numberBetween(1, 1000));
                preparedStatement.setString(4, "Medicine");
                preparedStatement.addBatch();
            }
            preparedStatement.execute("INSERT INTO categories (category_name) VALUES(\"Book\")");
            preparedStatement.execute("INSERT INTO categories (category_name) VALUES(\"Beer\")");
            preparedStatement.execute("INSERT INTO categories (category_name) VALUES(\"Medicine\")");
            preparedStatement.executeBatch();
            preparedStatement.close();
            if (preparedStatement.isClosed()) {
                System.out.println("Closed");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
