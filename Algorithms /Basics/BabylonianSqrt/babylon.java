import java.util.*;

public class babyloniansqrt {

       public static float sqrt(int n) {

              float x = n,
                    y = 1;

              double eps = 0.00001;

                    while(x - y > eps) {
                          x = (x + y) / 2;
                          y = n / x;
                    }
                    return x;

       }

       public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            System.out.print("Input = ");
            int n = scan.nextInt();
            float result = sqrt(n);
            System.out.println("Square Root of number = " + result);
       }
}
