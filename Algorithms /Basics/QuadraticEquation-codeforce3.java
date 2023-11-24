import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        if(c == 0 && b != 0 && a != 0) {
            quadraticFormula(a,b,c);
        }
        else if(b == 0 && c != 0 && a != 0){
            quadraticFormula(a,b,c);
        }
        else if(a == 0 && b != 0 && c != 0){
            System.out.println(1);
            System.out.printf("%.10f", (double)-c/b);
        }
        else if( a != 0 && b !=0 && c != 0){
            quadraticFormula(a,b,c);
        }
        else if(b != 0 && a == 0 && c == 0){
            System.out.println(1);
            System.out.printf("%.10f", (double)0);
        }
        else if( a != 0 && b == 0 && c == 0){
            System.out.println(1);
            System.out.printf("%.10f", (double)0);
        }
        else if( c!=0 && a==0 && b==0){
            System.out.println(0);
        }
        else{
            System.out.println(-1);
        }
 
    }
 
    public static void quadraticFormula(double a , double b , double c){
        double discriminant = (double) (b*b) - (4*a*c);
        if(discriminant > 0) {
            System.out.println(2);
            double result1 = (-b + (Math.sqrt((b * b) - (4 * a * c)))) / ((double)(2 * a));
            double result2 = (-b - (Math.sqrt((b * b) - (4 * a * c)))) / ((double)(2 * a));
            System.out.printf("%.10f\n", Math.min(result1,result2));
            System.out.printf("%.10f", Math.max(result1,result2));
        }
        else if(discriminant == 0 && a != 0){
            System.out.println(1);
            double result = -b/((double)(2*a));
            System.out.printf("%.10f",result);
        }
        else if(discriminant < 0){
            System.out.println(0);
        }
    }
}
