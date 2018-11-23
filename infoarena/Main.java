import java.util.Scanner;
import java.io.*;

public class Main {

       public static void __sort(int arr[]) {

              int i, 

                  j, 

                  finished = 0, 

                  swapped, 

                  n = arr.length - 1;
              
              while(finished == 0) {

                    swapped = 0;

                    for(i = 0; i < n - 1; i++) {

                        if(arr[i] > arr[i+1]) {

                           int holder = arr[i];

                               arr[i] = arr[i+1];

                               arr[i+1] = holder;

                               swapped = 1;      
                        }
                    } 

		    if(swapped == 1) n = n - 1;

                       else finished = 1;
              } 
       }

       public static void __csort(int arr[]) {

              double shrinkFactor = 1.3;

              int size = arr.length - 1, gap = size;
            
              boolean swapped = true;
               
              while(gap > 1 || swapped) {

                    swapped = false;

                    if(gap > 1) gap = (gap * 10) / 13;

                    for(int i = 0; i + gap < size; i++) {

                        if(arr[i] > arr[i+gap]) {

                           int holder = arr[i];

                               arr[i] = arr[i+gap];

                               arr[i+gap] = holder;

                               swapped = true;  
                        }  
                    }
              }   
       }

       public static void main(String[] args) {

              int n;

              int[] arr;

              String FIN = "algsort.in",

                     FOUT = "algsort.out";  

              try {
                      Scanner fin = new Scanner(new File( FIN ));

                      n = fin.nextInt();

                      arr = new int[n+1]; 

                      int k = 0;                     
 
                      while(fin.hasNext()) {

                            int i = fin.nextInt();

                            arr[k++] = i;
                      }  
                                             
                      __csort( arr );                     

                      final OutputStream os = new FileOutputStream( FOUT );

                      final PrintStream ps = new PrintStream( os );                       

                      for (int i = 0; i < n; i++) {

                           ps.print(arr[i]);

                           ps.print(" ");
                      }

                      ps.close();

              } catch(FileNotFoundException ex) {                   

                      System.out.println("Error: " + ex); 

              } 
       }
}
