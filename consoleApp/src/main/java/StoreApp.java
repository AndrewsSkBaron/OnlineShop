import com.onlineStore.coherent.order.Order;
import product.Product;


public class StoreApp {
    public static void main(String[] args) {
        Facade running = new Facade();
        running.run();
    }
}