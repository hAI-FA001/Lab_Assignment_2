import Product.Comparators.DateComparator;
import Product.Comparators.PriceComparator;
import Product.Comparators.QuantityComparator;
import Product.Comparators.RatingComparator;
import Product.Product;

import java.security.SecureRandom;
import java.sql.Date;
import java.util.*;

public class Demo {

    final static int NUM_OBJECTS_TO_ADD =10;

    public static void main(String[] args) {

        List products = new ArrayList<Product>();

        for(int i = 0; i < NUM_OBJECTS_TO_ADD; i++) {
            try {
                products.add(new Product("Product #" + (char) (i+65), ((i + 1) * 5 - 2), (i + 2), new SecureRandom().nextDouble(5.0),
                        new Date(110 + i, i % 12, i % 30)));
            } catch (IllegalArgumentException e) {
                i--;
            }
        }

        Collections.sort(products);
        printList(products);
        System.out.println("------------------------------------------------------");

        sortBy(products, new PriceComparator());
        printList(products);
        System.out.println("------------------------------------------------------");

        sortByAndPrintList(products, false, new RatingComparator());
        System.out.println("------------------------------------------------------");

        sortByAndPrintList(products, true, new DateComparator());
        System.out.println("------------------------------------------------------");

        sortBy(products, new QuantityComparator().reversed());
        printList(products);
        System.out.println("------------------------------------------------------");

        printListInReverse(products);
        System.out.println("------------------------------------------------------");
    }

    public static void sortBy(List<Product> products, Comparator<Product> comparator) {
        products.sort(comparator);
    }

    public static void sortByAndPrintList(List<Product> products, boolean inReverse, Comparator<Product> comparator){

        if (inReverse)
            sortBy(products, comparator.reversed());
        else
            sortBy(products, comparator);

        products.iterator().forEachRemaining(System.out::println);
    }

    public static void printList(List<Product> products){
        products.iterator().forEachRemaining(System.out::println);
    }

    public static void printListInReverse(List<Product> products){
        List p2 = new ArrayList();
        p2.addAll(products);
        Collections.reverse(p2);
        p2.iterator().forEachRemaining(System.out::println);
    }
}
