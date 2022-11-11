package Product;

import java.sql.Date;

public class Product implements Comparable<Product>{
    private String name;
    private double price;
    private int quantity;
    private double rating;
    private Date dateOfMFG;

    public Product(String name, double price, int quantity, double rating, Date dateOfMFG){

        validateAll(name, price, quantity, rating, dateOfMFG);

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
        this.dateOfMFG = dateOfMFG;
    }
    public Product(){

    }

    private void validateAll(String name, double price, int quantity, double rating, Date dateOfMFG) {
        validateName(name);
        validatePrice(price);
        validateQuantity(quantity);
        validateRating(rating);
        validateDate(dateOfMFG);
    }
    private void validateName(String name){
        if(name == null || name.equals(""))
            throw new IllegalArgumentException("Name must be non-null and non-empty");
    }
    private void validatePrice(double price){
        if(price <= 0.0)
            throw new IllegalArgumentException("Price must be > 0");
    }
    private void validateQuantity(int quantity){
        if(quantity <= 0)
            throw new IllegalArgumentException("Quantity must be >= 0");
    }
    private void validateRating(double rating){
        if(rating < 0.0 || rating > 5)
            throw new IllegalArgumentException("Rating must be >= 0 and <= 5");
    }
    private void validateDate(Date dateOfMFG){
        if(dateOfMFG == null)
            throw new IllegalArgumentException("Date cannot be null");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setDateOfMFG(Date dateOfMFG) {
        this.dateOfMFG = dateOfMFG;
    }

    public Date getDateOfMFG() {
        return dateOfMFG;
    }

    @Override
    public String toString(){
        return String.format("\n%-20s:\n\tPrice: $%,4.2f\t\tQuantity: %03d\n\tRating: %2.2f\t\tMFG: %-10s",
                name, price, quantity, rating, dateOfMFG);
    }

    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.name);
    }
}
