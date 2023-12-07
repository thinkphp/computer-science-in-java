import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    	
        // Example array of integers
        int[] array = {5, 3, 8, 2, 1};
        
        System.out.println("Sorted Array: " + Arrays.toString(array));

        // Sorting the array using Selection Sort
        selectionSort(array);

        // Displaying the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    // Implementation of Selection Sort algorithm
    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            // Assume the current index is the minimum
            int minIndex = i;

            // Find the index of the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the element at the current index
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
