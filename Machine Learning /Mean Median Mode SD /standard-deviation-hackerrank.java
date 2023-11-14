import java.io.*;
import java.util.*;

public class StandardDeviation {

    public static void main(String[] args) {
        /* Scan input */        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        /* Print answer */
        System.out.printf("%.1f", getStandarDeviation(arr));
    }

    private static double getMean(int[] arr) {
        int sum = 0;
        for (Integer num : arr) {
            sum += num;
        }
        double avg = (double) sum / arr.length;
        return avg;
    }    

    private static double getStandarDeviation(int[] arr) {
        /* Get mean(miu) */
        double mean = getMean(arr);

        double squaredSum = 0;
        for (int i = 0; i < arr.length; i++) {
            squaredSum += (arr[i] - mean) * (arr[i] - mean);
            // sum += Math.pow(arr[i] - mean, 2);
        }
        double variance = squaredSum / arr.length ;
        double sd = Math.sqrt(variance);
        return sd;
    }    
}
