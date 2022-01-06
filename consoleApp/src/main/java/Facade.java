import com.onlineStore.coherent.RandomStorePopulator;
import com.onlineStore.coherent.Store;
import database.DataBase;

import java.sql.SQLException;

public class Facade {
    public void run() throws SQLException {
        DataBase dataBase = new DataBase();
        dataBase.createDataBaseTables();
        dataBase.insertDataOfCategories();

        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        randomStorePopulator.insertDataOfProducts();
        Store store = randomStorePopulator.getRandomStore();
        Interaction interaction = new Interaction(store);
        interaction.changeTheIdToDisplayTheList();
        interaction.scannerUserInteraction();
    }
}
