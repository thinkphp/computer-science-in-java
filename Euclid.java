public class Euclid {

       //iterative implementation
       public static int gcd(int x, int y) {

              if( y == 0 ) return x;

              else return gcd( y, x % y ); 
       }

       //recursive implementation
       public static int gcd_rec(int x, int y) {

              while( y != 0 ) {

                   int holder = y;
 
                       y = x % y;  

                       x = holder;
              }

              return x;
       }

       public static void main(String[] args) {

              int x = Integer.parseInt(args[0]);

              int y = Integer.parseInt(args[1]);

              int r = gcd(x, y);

               System.out.println("Greatest Common Divisor ( " + x + ", " + y + " ) = " + r);

       }
}
