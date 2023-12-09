
//se numeste algoritmul prin insertie
public class QuickSortAlgorithm {

       public static void _QuickSort(int lo, int hi, int[] vec) {

         int i=lo,
             j=hi,
             pivot = vec[(hi+lo)>>1];
             
         while(i<=j) {
           while(vec[i]<pivot){ i++; }
           while(vec[j]>pivot){ j--; }
           if(i<=j){
             int tmp = vec[i];
                 vec[i]=vec[j];
                 vec[j]=tmp;
             i++;j--;
           }
         }
         if(lo<j) _QuickSort(lo,j,vec);
         if(i<hi) _QuickSort(i,hi,vec);
       }

       public static void QuickSort(int[] vec) {

              _QuickSort(0, vec.length - 1, vec);
       }

       public static void main(String args[]) {

              //declaram un vector de intregi
              int[] vector = {7,6,5,-4,3,2,-1,0};

              //afisam pe ecran un string
              System.out.println("vectorul original");

              //afisam vectorul pe stdout
              DisplayVector( vector );

              QuickSort( vector );

              //afisam pe ecran un string
              System.out.println("vectorul sortat");

              //afisam inca o data vectorul sortat
              DisplayVector( vector );
       }

       public static void DisplayVector(int[] vec) {

          for(int value: vec) {

                System.out.print(value + " ");
          }

          System.out.println();
       }
}
