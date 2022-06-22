import java.util.*;
public class Product extends Purchase {
    int id;
    String name;
    String description;
    String category;
    String brand;
    double price;
    int amountStock;

    public Product() {

    }
    public Product(int id, String name, String description, String category, String brand, double price, int amountStock) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.amountStock = amountStock;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id= id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name= name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description= description;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category= category;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand= brand;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price= price;
    }

    public int getAmountofStock() {
        return amountStock;
    }
    public void setAmountofStock(int amountStock) {
        this.amountStock = amountStock;
    }

    public void getAvailability(){
        for (Availability a:Availability.values()
             ) {
            System.out.println(a+" "+amountStock+" "+a.getStored());
        }
    }

    public String display() {
        return ("Id: " + id + " " + "Name: " + name + " " + "Description: " + description + " " + "category: " + category + " " + "Brand: " + brand + " " + "Price: " + price + " " + "Amount Stock: " + amountStock);
    }

}