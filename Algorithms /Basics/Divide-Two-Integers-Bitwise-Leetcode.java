import java.util.Scanner;

public class Divide {

        public static int DivideNumbers(int a, int b) {

              int dividend = Math.abs(a);

                  int divisor = Math.abs(b);

                  boolean sign = (a > 0 && b < 0) || (a < 0 && b > 0);

                  int s = 1;

                  if(sign == true) s = -1;


                  int multiply = 1;
                  int result = 0;

                  while(dividend >= divisor) {

                       multiply = 1;
                       int temp = divisor;

                       while((divisor<<1) <= dividend) {
                            divisor<<=1;
                            multiply<<=1;
                       }

                      dividend-=temp;
                      result+=multiply;
                  }

                  return s * result;
        }

        public static void main(String[] args) {

               Scanner scanner = new Scanner(System.in);

               System.out.print("Dividend = ");

               int divident = scanner.nextInt();

               System.out.print("Divisor = ");

               int divisor = scanner.nextInt();

               int result = DivideNumbers(divident,divisor);

               System.out.println(divident + "/" + divisor + " = " + result);
        }
}
