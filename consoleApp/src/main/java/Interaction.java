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

    private List<Product> getSortRandomProduct(List<Product> productsAll, Sort sort) {
        List<Product> sortProductsAll = new ArrayList<>(productsAll);

        sortProductsAll.sort((o1, o2) -> {
            int nameComp = o1.getName().compareToIgnoreCase(o2.getName());
            int priceComp = Double.compare(o1.getPrice(), o2.getPrice());
            int rateComp = Double.compare(o1.getRate(), o2.getRate());
            switch (sort.getName()) {
                case "asc":
                    if (nameComp != 0) return nameComp;
                    break;
                case "desc":
                    if (nameComp != 0) return -nameComp;
                    break;
                case "no":
                    break;
            }
            switch (sort.getPrice()) {
                case "asc":
                    if (priceComp != 0) return priceComp;
                    break;
                case "desc":
                    if (priceComp != 0) return -priceComp;
                    break;
                case "no":
                    break;
            }
            switch (sort.getRate()) {
                case "asc":
                    if (rateComp != 0) return rateComp;
                case "desc":
                    if (rateComp != 0) return -rateComp;
                default:
                    return 0;
            }
        });
        return sortProductsAll;
    }

    public void printOutAllSortedProducts() {
        List<Product> sortProductsAll = getSortRandomProduct(collectAllProductsInAnArray(), sort);
        System.out.println(sortProductsAll);
    }

    public void showSortByNamePrice() {
        List<Product> sortProductsAll = getSortRandomProduct(collectAllProductsInAnArray(), sort);
        Collections.sort(sortProductsAll, new SortByName().thenComparing(new SortByPrice()));
        sortProductsAll.forEach(System.out::println);
    }

    public void showBestOfProdByRate() {
        List<Product> sortProductsAll = getSortRandomProduct(collectAllProductsInAnArray(), sort);
        Collections.sort(sortProductsAll, new SortByRate());
        for (int i = 0; i < 5; i++) {
            System.out.print(sortProductsAll.get(i));
        }

    }

    public void scannerUserInteraction() {
        Scanner scanner = new Scanner(System.in);
        printOutAllSortedProducts();
        System.out.println();
        printOutInfoOfHelp();
        quit:
        while (true) {
            String option = scanner.nextLine();
            switch (option) {
                case "sort":
                    showSortByNamePrice();
                    System.out.println();
                    break;
                case "top":
                    showBestOfProdByRate();
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

