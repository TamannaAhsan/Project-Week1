import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String [] args) throws FileNotFoundException{

        Menu m = new Menu();
        m.arrayListStore();
        System.out.println("\n");
        m.runMenu();
        System.out.println();

        //FiLe Read From Text File//
        try{
            System.out.println();
            File file = new File("/Users/sazal/OneDrive/Documents/data.txt");
            Scanner fl = new Scanner(file);
            while(fl.hasNextLine()){
                System.out.println(fl.nextLine());
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found"+e);
        }
    }
}