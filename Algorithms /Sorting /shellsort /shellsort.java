import java.util.Arrays;

public class Main {

    public static void main( String[] args ) {

        // Example array of integers
        int[] array = { 5, 3, 8, -2, -1 };

        System.out.println(" Sorted Array: " + Arrays.toString( array ) );

        display( array );

        // Sorting the array using Selection Sort
        ShellSort( array );

        // Displaying the sorted array
        System.out.println(" Sorted Array: " + Arrays.toString( array ) );

        display( array );
    }

    // Implementation of Selection Sort algorithm
    public static void ShellSort(int[] array) {

           int dist[] = { 5, 3, 1 };
           int aux, i, j, k;

                      for( i = 0; i < dist.length; ++i) {

                           int d = dist[ i ];

                           for(j = d; j < array.length; ++j) {

                               aux = array[ j ];

                               for(k = j - d; k >= 0 && array[k] > aux; k-=d) {

                                   array[ k + d ] = array[ k ];

                               }

                               array[ k + d ] = aux;
                           }
                      }

    }

    public static void display(int arr[]) {

           for(int value : arr) {

               System.out.print(value + " ");
           }

               System.out.println();
    }
}

