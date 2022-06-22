import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class Purchase {

    int itemId;
    String itemName;
    int quantity;
    double price;

    public Purchase(){

    }

    public Purchase(int itemId, String itemName, int quantity, double price){
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getTotal() {
        return (getPrice() * getQuantity());
    }
    public String dateFormatter(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        strDate = formatter.format(date);
        return ("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);
    }

    public String purchaseDisplay(){
        return ("Purchase Details: "+"Item id: "+" "+itemId+" "+"Item Name: "+itemName+" "+"Item Quantity: "+quantity+" "+"Item Price: "+price+" "+"Total: "+getTotal());
    }

}