import com.onlineStore.coherent.RandomStorePopulator;
import com.onlineStore.coherent.Store;

import java.sql.SQLException;

public class Facade {
    public void run() throws SQLException {
        RandomStorePopulator faker = new RandomStorePopulator();
        faker.createTables();
        Store store = faker.getRandomStore();
        Interaction interaction = new Interaction(store);
        interaction.changeTheIdToDisplayTheList();
        interaction.scannerUserInteraction();
    }
}
