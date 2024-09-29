## Jumpsearch 

Jump Search is an efficient searching algorithm for sorted arrays, with a time complexity between linear search and binary search.



```java
public class JumpSearch {
    public static int jumpSearch(int[] arr, int x) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;

        // Finding the block where element is present (if it is present)
        while (arr[Math.min(step, n) - 1] < x) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        // Doing a linear search for x in block beginning with prev
        while (arr[prev] < x) {
            prev++;
            if (prev == Math.min(step, n))
                return -1;
        }

        // If element is found
        if (arr[prev] == x)
            return prev;

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
        int x = 55;

        int index = jumpSearch(arr, x);

        if (index != -1)
            System.out.println("Number " + x + " is at index " + index);
        else
            System.out.println("Number " + x + " is not in the array.");
    }
}

```

This implementation includes:

1. The `jumpSearch` method, which takes a sorted array and a target value as input.
2. A `main` method demonstrating how to use the `jumpSearch` function.

The algorithm works by:

1. Calculating the jump step size (square root of array length).
2. Jumping ahead by the step size to find the block where the element might be present.
3. Performing a linear search within that block.

The time complexity of Jump Search is O(√n), which is between linear search O(n) and binary search O(log n).
