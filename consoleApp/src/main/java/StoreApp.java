import com.onlineStore.coherent.RandomStorePopulator;
import com.onlineStore.coherent.Store;

public class StoreApp {
    public static void main(String[] args) {
        RandomStorePopulator faker = new RandomStorePopulator();
        Store store = faker.getRandomStore();

        Interaction interaction = new Interaction(store);
        interaction.scannerUserInteraction();
    }
}