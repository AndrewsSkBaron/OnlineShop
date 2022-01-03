package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnections {
    private final String URL = "jdbc:mysql://localhost:3306/db_shop";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Connected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
