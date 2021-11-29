import com.onlineStore.coherent.model.Root;
import com.onlineStore.coherent.model.Sort;
import com.onlineStore.coherent.parser.Parser;

import java.util.List;

public class StoreApp {
    public static void main(String[] args) {
//        RandomStorePopulator random = new RandomStorePopulator();
//        random.getRandomStore(3);
//        random.printInfoOfStore();
//       Interaction interaction = new Interaction();
//       interaction.scannerUserInteraction();
//        Parser parser = new Parser();
//        Root root = parser.parse();
//        final Parser parser = new Parser();
//         final Root root = parser.parse();
//         final Sort sort = root.getSort();
//
//        System.out.println(sort.getName());
//        System.out.println(sort.getPrice());
//        System.out.println(sort.getRate());
        Interaction interaction = new Interaction();
        interaction.printOutAllSortedProducts();
        //System.out.println(interaction.collectAllProductsInAnArray());
        //interaction.getBestOfProducts();

    }
}