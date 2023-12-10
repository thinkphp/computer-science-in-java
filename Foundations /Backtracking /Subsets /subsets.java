public class Main {

       static int stack[] = new int[100],
           n,
           level;

       public static void init() {
            stack[level] = -1;
       }

       public static boolean valid() {return true;}

       public static boolean succ() {

           if(stack[level]<1){
             stack[level]++;
             return true;
           }
           return false;
       }

       public static boolean sol() {
         return (level == n);
       }

       public static void main(String args[]) {
           n = 3;
           bk();
       }

       public static void bk() {
          level = 1;
          boolean s,v;
          init();
          while(level>0){
            s = true;
            v = false;
            while(s && !v){
              s = succ();
              if(s) v = valid();
            }
            if(s) {
             if(sol())print();
             else{
               level++;init();
             }
            }else{
              level--;
            }
          }
       }

       public static void print() {

         for(int i = 1; i <= n; ++i){
           if(stack[i] == 1) {
             System.out.print(i + " ");
           }
         }
         System.out.println("\n");
       }
}
