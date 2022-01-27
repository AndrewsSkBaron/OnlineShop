import com.onlineStore.coherent.RandomStorePopulator;
import com.onlineStore.coherent.Store;

public class Facade {
    public void run() {
        RandomStorePopulator random = new RandomStorePopulator();
        Store store = random.getRandomStore();
        Interaction interaction = new Interaction(store);
        interaction.collectAllProductsInAnArray();
        interaction.scannerUserInteraction();
    }
}
