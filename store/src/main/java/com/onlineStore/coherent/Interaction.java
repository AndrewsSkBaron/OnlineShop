package com.onlineStore.coherent;

import com.onlineStore.coherent.model.Root;
import com.onlineStore.coherent.model.Sort;
import com.onlineStore.coherent.parser.Parser;
import com.onlineStore.coherent.sort.SortByRate;

import java.util.*;

public class Interaction {

    public class StoreApp {
        private final RandomStorePopulator random = new RandomStorePopulator();
        private final Store store = random.getRandomStore(5);
        private final Parser parser = new Parser();
        private final Root root = parser.parse();
        private final Sort sort = root.getSort();


        public List collectAllProductsInAnArray(Store store) {
            List<Product> productsAll = new ArrayList<>();
            for (Category category : store.getCategories()) {
                productsAll.addAll(category.getListOfProducts());
            }
            return productsAll;
        }

        public void getSortRandomProducts(List list) {
            Comparator<Product> comp = Comparator.comparing(Product::getName).thenComparing(Product::getPrice);
            Collections.sort(list, comp);
            list.forEach(System.out::print);

        }

        public void getBestOfProducts(List list) {
            Collections.sort(list, new SortByRate());
            for (int i = 0; i < 5; i++) {
                System.out.print(list.get(i));
            }
        }

        public void scannerUserInteraction() {
            Scanner scanner = new Scanner(System.in);
            collectAllProductsInAnArray(store);
            printOutInfoOfHelp();
            quit:
            while (true) {
                String option = scanner.nextLine();
                switch (option) {
                    case "sort":
                        getSortRandomProducts(collectAllProductsInAnArray(store));
                        System.out.println();
                        break;
                    case "top":
                        getBestOfProducts(collectAllProductsInAnArray(store));
                        System.out.println();
                        break;
                    case "quit":
                        System.out.println();
                        System.out.println("Bye Bye");
                        break quit;
                    default:
                        printOutInfoOfHelp();
                }
            }
        }

        private static void printOutInfoOfHelp() {
            System.out.println(
                    "Please choose an action. Enter :\n"
                            + "sort - print list of products ordered according to config;\n"
                            + "top - print top 5 products sorted via price desc;\n"
                            + "quit - exit app;"
            );
        }

    }
}
