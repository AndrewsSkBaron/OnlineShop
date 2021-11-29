package com.onlineStore.coherent.sort;

import com.onlineStore.coherent.model.Root;
import com.onlineStore.coherent.model.Sort;
import com.onlineStore.coherent.parser.Parser;
import product.Product;

import java.util.Comparator;


public class SortByRate implements Comparator<Product> {

    private final Parser parser = new Parser();
    private final Root root = parser.parse();
    private final Sort sort = root.getSort();

    @Override
    public int compare(Product rate1, Product rate2) {

        switch (sort.getRate()) {
            case "asc":
                if (rate1.getRate() < rate2.getRate()) {
                    return 1;
                }
                if (rate1.getPrice() == rate2.getPrice()) {
                    return -1;
                }
                break;
            case "desc":
                if (rate1.getRate() > rate2.getRate()) {
                    return -1;
                }
                if (rate1.getPrice() == rate2.getPrice()) {
                    return 1;
                }
                break;
            default:
                return 0;
        }
        return 0;
    };

}
