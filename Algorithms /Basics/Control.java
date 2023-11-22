import java.util.Scanner;


public class control {

    public static void main(String args[]) {

        int n;

        Scanner scan = new Scanner(System.in);
        n  = scan.nextInt();
        if(n%9!=0) {         
           System.out.println(n%9); 
        } else {
           System.out.println(9); 
        }
 
        
    } 
}
