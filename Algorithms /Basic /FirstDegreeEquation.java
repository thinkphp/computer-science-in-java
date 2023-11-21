import java.util.Scanner;

public class FirstDegreeEquation {

       public static void main(String args[]) {

         System.out.println("Linear Equation Resolver");
         System.out.println("Given a equation as 'a * x + b = 0', please enter constants:");
         Scanner scan = new Scanner(System.in);
         double a, b, x;

         System.out.print("a: ");
         a = scan.nextDouble();

         System.out.print("b: ");
         b = scan.nextDouble();

         if(a!=0) {
           if(b!=0) {
             x = -b/a;
             System.out.printf("The solution is x =: %f!", x);
           } else {
             //it means b == 0
             x = 0;
             System.out.printf("The solution is: x = %d!", 0);
           }
         } else {
           //it means a == 0
           if(b!=0) {
             System.out.printf("The equation does not has solutions.");
           } else {
             // b == 0
             System.out.printf("The equation has an infinity solutions.");
           }
         }

       }
}

