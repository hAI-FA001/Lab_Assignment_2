package Product.Comparators;

import Product.Product;

import java.util.Comparator;

public class RatingComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {

        return Double.compare(o1.getRating(), o2.getRating());
    }
    @Override
    public Comparator<Product> reversed(){
        return Comparator.super.reversed();
    }
}
