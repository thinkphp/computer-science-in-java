import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Example array of integers
        int[] array = {5, 3, 8, 2, 1};

        System.out.println("Sorted Array: " + Arrays.toString(array));

        // Sorting the array using Selection Sort
        BubbleSort(array);

        // Displaying the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    // Implementation of Selection Sort algorithm
    public static void BubbleSort(int[] array) {

        int n = array.length;
        boolean swapped,
                finished = false;

        while(!finished) {
           swapped = false;
           for (int i = 0; i < n - 1; i++) {
              if(array[i]>array[i+1]){
              int tmp = array[i];
              array[i] = array[i+1];
              array[i+1] = tmp;
              swapped = true;
              }
            }
            if(swapped) n--;else finished = true;
          }
    }
}
