/*
A Program to find the square root of a number using Babylonian method.
*/
import java.util.*;

public class babyloniansqrt {
  
   public static float sqrt_babylon(int n) {

       float x = n;
       float y = 1;
       double eps = 0.000001;  
       while(x - y > eps) {
           x = ( x + y ) / 2;
           y = n / x;
       }
       return x;
   }
  
   public static void main(String args[]) {
          Scanner scan = new Scanner(System.in);
          System.out.print("Input an integer = ");    
          int n = scan.nextInt();
          double output = sqrt_babylon(n);
          System.out.println("Square Root of the number = " + output);
   }
}  
  
