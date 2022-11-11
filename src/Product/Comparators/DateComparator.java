package Product.Comparators;

import Product.Product;

import java.util.Comparator;

public class DateComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {

        return o1.getDateOfMFG().compareTo(o2.getDateOfMFG());
    }

    @Override
    public Comparator<Product> reversed(){
        return Comparator.super.reversed();
    }
}
