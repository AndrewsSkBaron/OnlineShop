import category.Category;
import com.onlineStore.coherent.RandomStorePopulator;
import com.onlineStore.coherent.Store;
import com.onlineStore.coherent.model.Root;
import com.onlineStore.coherent.model.Sort;
import com.onlineStore.coherent.parser.Parser;
import com.onlineStore.coherent.sort.SortByName;
import com.onlineStore.coherent.sort.SortByPrice;
import com.onlineStore.coherent.sort.SortByRate;

import product.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Interaction {
        private RandomStorePopulator random = new RandomStorePopulator();
        private final Store store = random.getRandomStore();
        private final Parser parser = new Parser();
        private final Root root = parser.parse();
        private final Sort sort = root.getSort();

        public List<Product> collectAllProductsInAnArray() {
            List<Product> productsAll = new ArrayList<>();
            for (Category category : store.getCategories()) {
                productsAll.addAll(category.getListOfProducts());
            }
            return productsAll;
        }
//
//        public void getSortRandomProducts(List list) {
//            Comparator<Product> comp = Comparator.comparing(Product::getName).thenComparing(Product::getPrice);
//            Collections.sort(list, comp);
//            list.forEach(System.out::print);
//
//        }
//
//        public void getBestOfProducts(java.util.List<Product> list) {
//            Collections.sort(list, new SortByRate());
//            for (int i = 0; i < 5; i++) {
//                System.out.print(list.get(i));
//            }
//        }


        private List<Product> getSortRandomProduct(List<Product> productsAll,Sort sort) {
            List<Product> sortProductsAll = new ArrayList<>(productsAll);


            switch (sort.getName()) {
                case "asc":
                    Collections.sort(sortProductsAll, new SortByName());
                    break;
                default:
                    return null;
            }
//            switch (sort.getPrice()) {
//                case "asc":
//                    Collections.sort(sortProductsAll, new SortByPrice());
//                    break;
//                default:
//                    return null;
//            }


            sortProductsAll.sort((o1, o2) -> {
                int name = o1.getName().compareToIgnoreCase(o2.getName());
                int price = Double.compare(o1.getPrice(), o2.getPrice());
                switch (sort.getName()) {
                    case "asc":
                        if (name != 0) return name;
                        break;
                    case "desc":
                        if (name != 0) return -name;
                        break;
                    default:
                        return 0;
                }
                switch (sort.getPrice()) {
                    case "asc":
                        if (price != 0) return price;
                        break;
                    case "desc":
                        if (price != 0) return -price;
                        break;
                    default:
                        return 0;
                }
                return 0;
            });
            return sortProductsAll;
        }
    public void printOutAllSortedProducts() {
        List<Product> sortedProducts = getSortRandomProduct(collectAllProductsInAnArray(), sort);
        sortedProducts.forEach(System.out::println);
    }
   public void getBestOfProducts() {
        List<Product> sortProductsAll = getSortRandomProduct(collectAllProductsInAnArray(), sort);
        Collections.sort(sortProductsAll, new SortByRate());
        for (int i = 0; i < 5; i++) {
            System.out.print(sortProductsAll.get(i));
        }
//
//        sortProductsAll.sort((o1, o2) -> {
//            int rate = Integer.compare(o1.getRate(), o2.getRate());
//            switch (sort.getRate()) {
//                case "asc":
//                    if (rate != 0) return rate;
//                    break;
//                case "desc":
//                    if (rate != 0) return -rate;
//                    break;
//                default:
//                    return 0;
//            }
//            return 0;
//        });
//        for (int i = 0; i < 5; i++) {
//            System.out.print(sortProductsAll.get(i));
//        }
    }


//    public void getBestOfProducts() {
//            SortByRate sort = new SortByRate();
//            List<Product> sortProductsAll = getSortRandomProduct(collectAllProductsInAnArray(store));
//            for (int i = 0; i < 5; i++) {
//                System.out.print(sortProductsAll.get(i) + "\n");
//            }
//        }

        public void scannerUserInteraction() {
            Scanner scanner = new Scanner(System.in);
            printOutInfoOfHelp();
            quit:
            while (true) {
                String option = scanner.nextLine();
                switch (option) {
                    case "sort":
                        printOutAllSortedProducts();
                        System.out.println();
                        break;
                    case "top":
                        getBestOfProducts();
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

