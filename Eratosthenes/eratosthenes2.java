import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Eratosthenes {

       public static int Eratos(int n) {

              int[] sieve;

              int primes = n - 1;

              sieve = new int[n+1];

              for(int i = 0; i <= n; ++i) {

                  sieve[i] = 1;
              }

              int i = 2, z;

              while(i * i <= n) {

                   if( sieve[ i ] == 1 ) {

                       z = 2;
                       while( (i * z) <= n ) {

                             int multiply = i * z;

                             if(sieve[multiply]==1) {

                                primes = primes - 1;
                             }

                             sieve[ multiply ] = 0;

                             z = z + 1;
                       }
                   }
                   i = i + 1;
              }

              return primes;
       }

       public static void main(String args[]) {

              int n;

              Scanner scan = new Scanner(System.in);

              System.out.print("N = ");

              n = scan.nextInt();

              scan.close();

              int primes = Eratos( n );

              System.out.println( primes );
       }
}
