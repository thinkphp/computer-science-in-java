public class BinarySearchIterative {

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 6;

        int result = binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }

    // Iterative Binary Search function
    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the target is present at the middle
            if (arr[mid] == target) {
                return mid;
            }

            // If the target is smaller than the middle element, search in the left subarray
            if (arr[mid] > target) {
                high = mid - 1;
            }

            // If the target is larger than the middle element, search in the right subarray
            else {
                low = mid + 1;
            }
        }

        // If the target is not present in the array
        return -1;
    }
}
