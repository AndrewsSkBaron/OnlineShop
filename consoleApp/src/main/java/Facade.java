import com.onlineStore.coherent.RandomStorePopulator;
import com.onlineStore.coherent.Store;

public class Facade {
    public void run() {
        RandomStorePopulator faker = new RandomStorePopulator();
        Store store = faker.getRandomStore();

        Interaction interaction = new Interaction(store);
        interaction.scannerUserInteraction();
    }
}
