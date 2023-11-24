/*
 * Author: Adrian Statescu.
 * Description: Control Digit Algorithm.
 * Date: __
 * License: MIT
 */
import java.util.Scanner;

public class Main {

    public static int Control1(int n) {

           if(n % 9 != 0) {

               return n % 9;

           } else return 9;
    }

    public static int Control2(int n) {

        int sum = 0;

        while(n > 9 ) {

            sum = 0;

            while(n > 0) {

                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        return sum;
    }

    public static void main(String[] args) {

           System.out.println( "Give a n = " );

           Scanner keyboard = new Scanner( System.in );

           int n;

           n = keyboard.nextInt();

           System.out.println("Digit Control = " + Control2( n ));

           System.out.println("Digit Control = " + Control1( n ));
    }
}
