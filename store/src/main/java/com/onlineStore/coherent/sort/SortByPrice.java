package com.onlineStore.coherent.sort;


import com.onlineStore.coherent.model.Root;
import com.onlineStore.coherent.model.Sort;
import com.onlineStore.coherent.parser.Parser;
import product.Product;

import java.util.Comparator;

public class SortByPrice implements Comparator<Product> {
    private final Parser parser = new Parser();
    private final Root root = parser.parse();
    private final Sort sort = root.getSort();

    @Override
    public int compare(Product price1, Product price2) {

        switch (sort.getPrice()) {
                    case "asc":
                        if(price1.getPrice() < price2.getPrice()) {
                            return -1;
                        }
                        if(price1.getPrice() ==  price2.getPrice()) {
                            return 1;
                        }
                        break;
                    case "desc":
                        if(price1.getPrice() > price2.getPrice()) {
                            return 1;
                        }
                        if(price1.getPrice() ==  price2.getPrice()) {
                            return -1;
                        }
                        break;
                    default:
                        return 0;
                }

//        if (price1.getPrice() < price2.getPrice()) {
//            return 1;
//        }
//        if (price1.getPrice() == price2.getPrice()) {
//            return 0;
//        }


        return 0;
    }

}
