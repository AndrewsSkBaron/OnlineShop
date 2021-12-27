import java.sql.SQLException;

public class StoreApp {
    public static void main(String[] args) throws SQLException {
        Facade running = new Facade();
        running.run();
    }
}