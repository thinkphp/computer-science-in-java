import java.util.Scanner;

public class nature {

       public static double sqrt(double n) {
              double x, y, eps = 0.000001;
              x = n;
              y = 1.0;
              while(x - y > eps) {
                x = (x + y) / 2;
                y = n / x;
              }
              return x;
       }

       public static void NatureRootsQuadraticEquation( double a, double b, double c ) {

              double S, P, Delta, x1, x2;

              S = -b/a;
              P = c/a;
              Delta = b*b - 4*a*c;
              System.out.println("\nVerify: ");
              if(Delta < 0) {
                System.out.println("Imaginary");
              } else {
                x1 = (-b-sqrt(Delta))/(2*a);
                x2 = (-b+sqrt(Delta))/(2*a);
                System.out.printf("x1 = %.2f\n",x1);
                System.out.printf("x2 = %.2f\n",x2);
                if( S >= 0 ) {
                    if(P > 0) {
                       System.out.println("x1 > 0 positive, x2 > 0 positive");
                    } else if(P < 0){
                       System.out.println("x1 < 0 negative, x2 > 0 negative, |x1| < |x2|");
                    } else {
                       System.out.println("x1 = 0 ,x2 > 0");
                    }
                //the S < 0 negative
                } else {
                  if(P > 0) {
                     System.out.println("x1 < 0 positive, x2 < 0 negative");
                  } else if(P < 0){
                     System.out.println("x1 < 0 negative, x2 > 0 negative, |x1| > |x2|");
                  } else {
                     System.out.println("x1 = 0 ,x2 < 0");
                  }
                }
              }
       }

       public static void main( String args[] ) {

              double a, b, c;
              Scanner keyboard = new Scanner( System.in );
              if(args.length > 1){
              a = Double.parseDouble(args[0]);
              b = Double.parseDouble(args[1]);
              c = Double.parseDouble(args[2]);
            } else {
              System.out.println("Give A, B, C for Ax^2 + Bx + C = 0: ");
              a = keyboard.nextDouble();
              b = keyboard.nextDouble();
              c = keyboard.nextDouble();
            }
              System.out.printf("The nature of the Roots Quadratic Equation: %.2fx^2 + %.2fx + %.2fc = 0", a, b, c);
              NatureRootsQuadraticEquation(a,b,c);
       }
}
