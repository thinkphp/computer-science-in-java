import java.util.*;

public class Main {

   public static void main(String[] args) {

     int[] arr = {9,8,7,6,-5,-4,-31,2,1};

     System.out.println("Input:");
     display(arr);
     mergesort(arr);
     System.out.println("\nOutput:");
     display(arr);
     System.out.println("\n");
   }

   public static void display(int arr[]) {

          for(int value: arr) {

              System.out.print(value + " ");
          }
   }

   public static void mergesort(int[] arr) {
          divideEtImpera(0,arr.length-1,arr);
   }

   public static void divideEtImpera(int lo, int hi, int arr[]) {
          if(lo == hi) return;
          int middle = (lo+hi)>>1;
          divideEtImpera(lo,middle, arr);
          divideEtImpera(middle+1,hi,arr);
          merge(lo,middle,hi,arr);
   }

   public static void merge(int lo, int m, int hi, int[] vec) {
         int i=lo, j=m+1, k = 0;
         int aux[] = new int[hi-lo+1];
         while(i<=m && j<=hi) {
             if(vec[i]<vec[j]) aux[k++] = vec[i++];
                     else aux[k++] = vec[j++];
         }
         while(i<=m) aux[k++] = vec[i++];
         while(j<=hi) aux[k++] = vec[j++];
         k = 0;
         for(int index=lo;index<=hi;index++) vec[index] = aux[k++];
   }
}

