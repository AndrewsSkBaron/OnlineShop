import com.onlineStore.coherent.RandomStorePopulator;
import com.onlineStore.coherent.Store;
import product.Product;

public class Facade {
    public void run() {
        RandomStorePopulator faker = new RandomStorePopulator();
        Store store = faker.getRandomStore();
        Interaction interaction = new Interaction(store);
        for (Product list :  interaction.collectAllProductsInAnArray()) {
            System.out.println(list);
        }
        interaction.scannerUserInteraction();
    }
}
