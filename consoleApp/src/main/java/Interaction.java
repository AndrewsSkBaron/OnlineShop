import com.onlineShop.coherent.category.Category;
import com.onlineShop.coherent.product.Product;
import com.onlineStore.coherent.Store;
import com.onlineStore.coherent.model.Sort;
import com.onlineStore.coherent.multithreading.ThreadAddProductsInOrder;
import com.onlineStore.coherent.multithreading.ThreadDeleteOrder;
import com.onlineStore.coherent.parser.Parser;
import com.onlineStore.coherent.sort.SortByName;
import com.onlineStore.coherent.sort.SortByPrice;
import com.onlineStore.coherent.sort.SortByRate;

import java.util.*;

public class Interaction {
    private Store store;
    private final Parser parser = new Parser();
    private final Sort sort = parser.parse();
    private final List<Product> productsToOrder = Collections.synchronizedList(new ArrayList<>());
    ThreadDeleteOrder threadDeleteOrder;

    public Interaction(Store store) {
        this.store = store;
        this.threadDeleteOrder = new ThreadDeleteOrder(productsToOrder);
    }

    public List<Product> collectAllProductsInAnArray() {
        List<Product> productsAll = new ArrayList<>();
        for (Category category : store.getCategories()) {
            productsAll.addAll(category.getListOfProducts());
        }
        return productsAll;
    }

    public void additionsStream(long number) {
        for (Product product : collectAllProductsInAnArray()) {
            if (product.getId() == number) {
                 ThreadAddProductsInOrder addProductsInOrder = new ThreadAddProductsInOrder(productsToOrder, product);
                addProductsInOrder.start();
                System.out.println("Product " + product.getName() + " Is already Added ");
                System.out.println(addProductsInOrder.getState());
            }
        }
    }

    private List<Product> getSortRandomProduct(List<Product> productsAll) {
        List<Product> sortProductsAll = new ArrayList<>(productsAll);
        Comparator sortByName, sortByPrice, sortByRate;

        switch (sort.getName()) {
            case "asc":
                sortByName = new SortByName();
                break;
            case "desc":
                sortByName = new SortByName().reversed();
                break;
            default:
                return null;
        }
        switch (sort.getPrice()) {
            case "asc":
                sortByPrice = new SortByPrice();
                break;
            case "desc":
                sortByPrice = new SortByPrice().reversed();
                break;
            default:
                return null;
        }
        switch (sort.getRate()) {
            case "asc":
                sortByRate = new SortByRate();
                break;
            case "desc":
                sortByRate = new SortByRate().reversed();
                break;
            default:
                return null;
        }

        Collections.sort(sortProductsAll, sortByName.thenComparing(sortByPrice).thenComparing(sortByRate));
        return new ArrayList<>(sortProductsAll);
    }

    public void showBestOfProdByRate() {
        List<Product> products = collectAllProductsInAnArray();
        Collections.sort(products, new SortByRate().reversed());
        for (int i = 0; i < 5; i++) {
            System.out.print(products.get(i));
        }
    }

    public void scannerUserInteraction() {
        //threadDeleteOrder.start();
        Scanner scanner = new Scanner(System.in);

        long number = 0;
        System.out.println();
        printOutInfoOfHelp();
        quit:
        while (true) {
            String option = scanner.nextLine();
            switch (option) {
                case "add":
                    number = scanner.nextLong();
                    additionsStream(number);
                    scanner.nextLine();
                    break;
                case "sort":
                    System.out.println(getSortRandomProduct(collectAllProductsInAnArray()));
                    System.out.println();
                    break;
                case "top":
                    showBestOfProdByRate();
                    System.out.println();
                    break;
                case "help":
                    printOutInfoOfHelp();
                    break;
                case "quit":
                    threadDeleteOrder.interrupt();
                    System.out.println();
                    System.out.println("Bye Bye");
                    break quit;
                default:
                    printOutError();
                    System.out.println();
                    printOutInfoOfHelp();
            }
        }
    }

    private static void printOutInfoOfHelp() {
        System.out.println(
                "Please choose an action. Enter :\n"
                        + "sort - print list of products ordered according to config;\n"
                        + "top - print top 5 products sorted via price desc;\n"
                        + "add -  adds the product to the order. Enter \"add\" and \"ProductID\" \n"
                        + "help - print all possible actions \n"
                        + "quit - exit app;"
        );
    }

    private static void printOutError() {
        System.out.println(
                "Error. \n"
                        + "The wrong action was entered. \n"
                        + "Please repeat the entry."
        );
    }
}