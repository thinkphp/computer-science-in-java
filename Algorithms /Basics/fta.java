import java.util.Scanner;

public class Main {

       public static void ApplyFTA(int n) {

              int fm, i = 2;

              while(!(n == 1)) {

                     fm = 0;

                     while(n % i == 0) {

                       n /= i;

                       fm += 1;

                     }

                     if( fm != 0 ) System.out.println(i + " * " + fm);
                     i += 1;
              }
       }

       public static void main(String args[]) {

              System.out.println("Fundamental Theorem of Arithmetic");

              System.out.print("N = ");

              Scanner keyboard = new Scanner( System.in );

              int n = keyboard.nextInt();

              ApplyFTA( n );
       }
}
