import com.onlineStore.coherent.RandomStorePopulator;
import com.onlineStore.coherent.Store;
import database.DBFill;

import java.sql.SQLException;

public class Facade {
    public void run() throws SQLException {
        DBFill dbFill = new DBFill();
        dbFill.insertData();

        RandomStorePopulator randomStorePopular = new RandomStorePopulator();
        Store store =  randomStorePopular.getRandomStore();
        Interaction interaction = new Interaction(store);
        interaction.changeTheIdToDisplayTheList();
        interaction.scannerUserInteraction();
    }
}
