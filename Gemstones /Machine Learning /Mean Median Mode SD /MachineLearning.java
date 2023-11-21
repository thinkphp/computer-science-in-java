import java.util.*;

public class MachineLearning {

        public static double getStandardDeviation(double[] arr, int n) {

               double sum = 0.0,
                      sd = 0.0;

               for( double elem: arr ) {

                    sum += elem;
               }

               double mean = sum / n;

               for( double elem: arr ) {

                 sd += Math.pow( elem - mean, 2 );

               }

               return Math.sqrt( sd );
        }

        public static double getMode(double[] arr, int n) {

               double[] copy  = Arrays.copyOf( arr, arr.length );

               Arrays.sort(copy);

               for (int i = 0, j = copy.length - 1; i < copy.length / 2;i++) {
                   double tmp = copy[i];
                   copy[i] = copy[j];
                   copy[j] = tmp;
                   j--;
               }

               double mode = 0, tmp = 1, nums = 1;

               for (int i = 0; i < n ; i++ ) {

                 for (int j = 0; j < n ; j++ ) {

                   if(copy[i]==copy[j] && i!=j) {

                      nums+=1;
                   }
                   if(tmp <= nums) {

                      mode = copy[i];

                      tmp = nums;
                   }
                 }
                  nums = 1;
               }
               return mode;
        }

        public static double getMedian(double[] arr, int n) {

               double[] copy  = Arrays.copyOf(arr, arr.length);

               Arrays.sort(copy);

               return (copy.length % 2 != 0) ? copy[ copy.length / 2 ] : (copy[ copy.length / 2 ] + copy[ (copy.length / 2) - 1 ]) / 2.0;
        }

        public static double getMean(double[] arr, int n) {

               double sum = 0;

               for(double elem:arr) {

                 sum += elem;
               }

               return sum/n;
        }

        public static void main(String[] args) {

          //double[] speed = {99,86,87,88,111,86,103,87,94,78,77,85,86};
          double[] speed = {64630,11735,14216,99233,14470,4978,73429,38120,51135,67060};
          /* Save input */
          /*
          Scanner scan = new Scanner(System.in);

          int size = scan.nextInt();

          double [] speed = new double[size];

          for (int i = 0; i < size; i++) {
               speed[i] = scan.nextDouble();
          }

          scan.close();
          */

          int n = speed.length;
          double ans;
          double mode;
          ans = getStandardDeviation(speed, n);
          System.out.printf("Standard Deviation = %.1f\n", ans);
          ans = getMean(speed, n);
          System.out.printf("Mean = %.1f\n", ans);
          ans = getMedian(speed, n);
          System.out.printf("Median = %.1f\n", ans);
          mode = getMode(speed, n);
          System.out.printf("Mode = %d\n", (int)mode);
        }
}
