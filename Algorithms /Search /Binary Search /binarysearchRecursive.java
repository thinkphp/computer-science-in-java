public class BinarySearchRecursive {

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 6;

        int result = binarySearch(sortedArray, target, 0, sortedArray.length - 1);

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }

    // Recursive Binary Search function
    static int binarySearch(int[] arr, int target, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            // If the target is present at the middle
            if (arr[mid] == target) {
                return mid;
            }

            // If the target is smaller than the middle element, search in the left subarray
            if (arr[mid] > target) {
                return binarySearch(arr, target, low, mid - 1);
            }

            // If the target is larger than the middle element, search in the right subarray
            return binarySearch(arr, target, mid + 1, high);
        }

        // If the target is not present in the array
        return -1;
    }
}
