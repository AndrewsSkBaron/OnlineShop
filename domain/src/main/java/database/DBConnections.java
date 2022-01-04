package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnections {
    private static final String URL = "jdbc:mysql://localhost:3306/db_shop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;

    private DBConnections() {}

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
