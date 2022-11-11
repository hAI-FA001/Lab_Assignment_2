package Product.Comparators;

import Product.Product;

import java.util.Comparator;

public class QuantityComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {

        return Integer.compare(o1.getQuantity(), o2.getQuantity());
    }
    @Override
    public Comparator<Product> reversed(){
        return Comparator.super.reversed();
    }
}
