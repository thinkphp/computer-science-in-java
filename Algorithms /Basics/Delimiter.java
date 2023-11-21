import java.util.*;

public class Delimiter {
     public static void main(String args[]){
            // Initialize Scanner object
            String str = "JavaTpoint/Abhishek/Male/22";
            Scanner scan = new Scanner(str);
            //Initialize the string delimiter
            scan.useDelimiter("/");
            //Printing the tokenized Strings
            while(scan.hasNext()){
                System.out.println(scan.next());
            }
            scan.close();
          }
}
