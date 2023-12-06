//se numeste algoritmul prin insertie
public class InsertSort {

       public static void InsertSort(int[] vec) {

         int n = vec.length;

         //{7, 6, 5, -4,3,2,-1,0};
         //{2, 7, 5,-4,3,2,-1,0};
         //{2, 5, 7,-4,3,2,-1,0};
          //  i:1 2 3 4 5 6 7 8
            //aux = vec[i] = 6
            //j= i-1 = 0
            //vec[0] = 7
         for(int i = 1; i < n; ++i) {

             int aux = vec[i];

             int j = i - 1;

             while(j >= 0 && vec[ j ] > aux) {

               vec[j+1] = vec[j];

               j-=1;
             }
             vec[j+1] = aux;
         }
       }

       public static void main(String args[]) {

              //declaram un vector de intregi
              int[] vector = {7,6,5,-4,3,2,-1,0};

              //afisam pe ecran un string
              System.out.println("vectorul original");

              //afisam vectorul pe stdout
              DisplayVector( vector );

              InsertSort( vector );

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

/*
VECTOR: 7 8 1 5 9
    i:  0 1 2 3 4
    j = i - 1
    <----
    for(i = 1; i < lungime_VECTOR; ++i) {
        temp = vec[i]
        j = i - 1;//j = 0
        while(j >= 0 SI vec[j] > temp) {
           vec[j+1] = vec[j]
          j--;
          //j = j -1
       }
       vec[j+1] = aux;
       //vec[-1+1] = aux
       //vec[0] = aux
    }
*/
