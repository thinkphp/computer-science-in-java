import java.util.Scanner;
import java.io.*;

public class Main {

	    public static int pow(int a, int b) {

	    	   int r = 1;

	    	   for(int i = 1; i <= b; ++i) {

                   r = r * a;
	    	   }

	    	   return r;
	    }

	    public static void generate_all_subsets(int n) {

             String FOUT = "submultimi.out";

             try {

	    	   final OutputStream os = new FileOutputStream( FOUT );

               final PrintStream ps = new PrintStream( os ); 

               int total = pow(2, n);               

               for(int i = 1; i < total; ++i) {

               	   for(int j = 0; j < n; ++j ) {                       
                       
               	   	   if((i & (1<<j))!=0) { 

               	   	   	       ps.print(j+1); 

               	   	   	       ps.print(" ");
               	   	   }	       
               	   } 

               	   ps.print("\n");      
               }               


               } catch(FileNotFoundException ex) {                   

                      System.out.println("Error: " + ex); 

              } 
        }


       public static void main(String[] args) {

       	      String FIN = "submultimi.in";                       

                     int n;

              try {
                      Scanner fin = new Scanner(new File( FIN ));

                      n = fin.nextInt();  

                      generate_all_subsets( n );	                    

                  } catch(FileNotFoundException ex) {                   

                      System.out.println("Error: " + ex); 

                  }                       		     	       	      
       }
}       
