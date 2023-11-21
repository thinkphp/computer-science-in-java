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

       public static void main(String[] args) throws Exception{

          if(args.length > 1) {

                 int x, y; 
 
              try{

                  x = Integer.parseInt(args[0]);

                  if(x < 0) throw new MyOwnException("Error -> First argument must be positive!");  

                 } catch(NumberFormatException e) {
                  
                   System.out.println("First arg must enter a number!");                  

                   return; 
                 }

                 try {

                     y = Integer.parseInt(args[1]);

                     if(y < 0) throw new MyOwnException("Error -> Second argument must be positive!");

                 }catch(NumberFormatException e) {

                     System.out.println("Second arg must be a number!");

                     return;
                 }

              int r = gcd(x, y);

               System.out.println("Greatest Common Divisor ( " + x + ", " + y + " ) = " + r);

          } else {

               System.out.println("Must enter two numbers as arguments");  

               return;
          }

       }
}
