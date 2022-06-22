import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.Comparator;
public class Menu extends Product{
    boolean exit;
    ArrayList<Product> product = new ArrayList<Product> ();

    public Menu(){
        super();
    }

    public Menu(int id, String name, String description,String category,String brand,double price,int amountStock,ArrayList<Product> product){
        super(id, name, description,category,brand,price,amountStock);
    }
    public void arrayListStore(){

        Product p1 = new Product(1,"Nokia C30","Nokia C30 SmartPhone","Mobile","Nokia",35000.00,23);
        Product p2 = new Product(2,"Samsung Galaxy","Samsung Galaxy SmartPhone","Mobile","Samsung",29000.00,14);
        Product p3 = new Product(3,"Nokia C20","Nokia C20 SmartPhone","Mobile","Nokia",25000.00,30);

        product.add(p1);
        product.add(p2);
        product.add(p3);
        for (Product pr: product
        ) {
            System.out.println(pr.display());
        }
    }

    public void showCategory(){
        for (Product pr: product
        ) {
            System.out.println("Categories: "+pr.getCategory());
        }
    }
    public void showBrand(){
        for (Product pr: product
        ) {
            System.out.println("Brands: "+pr.getBrand());
        }
    }
    public void showProducts(){
        for (Product pr: product
        ) {
            System.out.println("Products with price: "+pr.getId()+" "+pr.getName()+" "+pr.getPrice()+" ");
        }
    }

    //Descending//
    public void showLowerPrice (){
        Collections.sort(product, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.valueOf(o1.getPrice()).compareTo(o2.getPrice()) ;
            }
        });
        for (Product pr: product
        ) {
            System.out.println("Lower Price Products: "+"Id: "+pr.getId()+" "+"Name: "+pr.getName()+" "+"Brand: "+pr.getBrand()+" "+"Price: "+pr.getPrice());

        }
    }

    //Ascending//
    public void showHigherPrice (){
        Collections.sort(product, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.valueOf(o2.getPrice()).compareTo(o1.getPrice()) ;
            }
        });
        for (Product pr: product
        ) {
            System.out.println("Higher Price Products: "+"Id: "+pr.getId()+" "+"Name: "+pr.getName()+" "+"Brand: "+pr.getBrand()+" "+"Price: "+pr.getPrice());

        }
    }

    //Name sort Ascending//
    public void showSortName (){
        Collections.sort(product, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return String.valueOf(o1.getName()).compareTo(o2.getName()) ;
            }
        });
        for (Product pr: product
        ) {
            System.out.println("Sorted Name: "+"Name: "+pr.getName()+" "+"id: "+pr.getId()+" "+"Brand: "+pr.getBrand()+" "+"Price: "+pr.getPrice());

        }
    }
    private void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|    Welcome to E-Commerce Site     |");
        System.out.println("+-----------------------------------+");
        System.out.println("\n");
    }

    private void printMenu() {
        System.out.println("Please make a selection");
        System.out.println("0) To Check Categories, Please press 0 ");
        System.out.println("1) To Check Brands, Please press 1 ");
        System.out.println("2) Select 2 ");
        System.out.println("3) To Check Products and Price, Please press 3 ");
        System.out.println("4) To Check Sorted Names, Please press 4 ");
        System.out.println("5) To Check Low to High Price and Products, Please press 5 ");
        System.out.println("6) To Check High to Low Price and Products 6 ");
        System.out.println("7) Purchase Products 7 ");
        System.out.println("8) Exit the Application 8 ");
    }

    private int getInput(){
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option <= 0 || option >=8){
            try{
                System.out.println("\nEnter your choice: ");
                option = Integer.parseInt(sc.nextLine());
                performAction(option);
                if(option==8){
                    exit=true;
                    break;
                }
                //option = sc.nextInt();

            }catch(NumberFormatException e){
                System.out.println("NumberFormatException"+e);
            }
        }
        return option;
    }
    public void runMenu(){
        printHeader();
        printMenu();
        while(!exit){
            int option = getInput();
        }
    }

    public void getPurchase (){
        Scanner sc = new Scanner(System.in);
        Purchase p1 = new Purchase(1,"Mac",2,30000.00);
        System.out.println("Enter Product Name: ");
        String iname = sc.nextLine();
        System.out.println("Enter Quantity: ");
        int iquantity = sc.nextInt();
        double iprice = p1.getPrice();
        double iTotal = iprice * iquantity;
        System.out.println("Item price: "+iprice);
        System.out.println("Total Purchase: "+iTotal);
        System.out.println(p1.dateFormatter());
        System.out.println("Product Purchased Successfully\n");
        System.out.println ("Purchase Details\n"+"Item Name: "+iname+" "+"Quantity: "+iquantity+ "\n"+"Price: "+iprice+" "+"Total Purchase: "+iTotal+"\n"+(p1.dateFormatter()));

        //Write and Append File//
        try {
            FileWriter myWriter = new FileWriter("purchaselog.txt",true);
            myWriter.write("Purchase Details"+" "+"Item Name: "+iname+" "+"Quantity: "+iquantity+" "+"Price: "+iprice+" "+"Total Purchase: "+iTotal+" "+(p1.dateFormatter()));
            BufferedWriter b = new BufferedWriter(myWriter);
            b.write("Purchase Details"+" "+"Item Name: "+iname+" "+"Quantity: "+iquantity+" "+"Price: "+iprice+" "+"Total Purchase: "+iTotal+" "+(p1.dateFormatter()));
            b.newLine();
            b.close();
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred."+e);
        }
    }

    private void performAction(int option){
        switch (option){

            case 0:
                showCategory();
                break;
            case 1:
                showBrand();
                break;
            case 2:
                getAvailability();
                System.out.println("This Part is not fully complete, Please Press 3");
                break;
            case 3:
                showProducts();
                break;
            case 4:
                showSortName();
                break;

            case 5:
                showLowerPrice();
                break;
            case 6:
                showHigherPrice();
                break;
            case 7:
                getPurchase();
                break;

            case 8:
                System.out.println("Thank you for using our application");
                break;

            default: System.out.println("An unknown error has occurred");
                break;
        }
    }
}