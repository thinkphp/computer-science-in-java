import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Scanner;
 
/**
 * Created on 07/10/14.
 * Ax2 + Bx + C = 0.
 Your task is to find the number of distinct roots of the equation and print all of them in ascending order.
 
 Input
 The first line contains three integer numbers A, B and C ( - 10^5 ≤ A, B, C ≤ 10^5). Any coefficient may be equal to 0.
 
 Output
 In case of infinite root count print the only integer -1. In case of no roots print the only integer 0.
 In other cases print the number of root on the first line and the roots on the following lines in the ascending order.
 Print roots with at least 5 digits after the decimal point.
 */
public class Main {
 
    public static final String FORMAT = "%.5f";
    public static final double ZERO = 0;
 
 
    private void solve(double a, double b, double c) {
        // consider 8 cases
 
        // 000
        // infinite # of roots
        if (a == 0 && b == 0 && c == 0) {
            System.out.println(-1);
            return;
        }
 
        // 001
        // equation: c = 0 where c != 0 doesn't have roots
        if (a == 0 && b == 0 && c != 0) {
            System.out.println(0);
            return;
        }
 
        // 010
        // bx = 0, one zero root
        if (a == 0 && b != 0 && c == 0) {
            System.out.println(1);
            System.out.format(FORMAT, ZERO);
            return;
        }
 
        // 011
        // bx + c = 0
        // one root
        if (a == 0 && b != 0 && c != 0) {
            System.out.println(1);
            System.out.format(FORMAT, -c / b);
            return;
        }
 
        // 100
        // ax^2 = 0
        // one distinct root
        if (a != 0 && b == 0 && c == 0) {
            System.out.println(1);
            System.out.format(FORMAT, ZERO);
            return;
        }
 
        // 101
        // ax^2 + c = 0
        if (a != 0 && b == 0 && c != 0) {
            if (a * c < 0) {
                System.out.println(2);
                System.out.format(FORMAT, - Math.sqrt(-c / a));
                System.out.println();
                System.out.format(FORMAT, Math.sqrt(-c / a));
            }
            else {
                System.out.println(0);
            }
            return;
        }
 
        // 110
        // ax^2 + bx = 0
        if (a != 0 && b != 0 && c == 0) {
            System.out.println(2);
            if (-b / a > 0) {
                System.out.format(FORMAT, ZERO);
                System.out.println();
                System.out.format(FORMAT, -b / a);
            }
            else {
                System.out.format(FORMAT, -b / a);
                System.out.println();
                System.out.format(FORMAT, ZERO);
            }
 
            return;
        }
 
        // 111
        // ax^2 + bx + c = 0
        if (a != 0 && b != 0 && c != 0) {
            double d = b * b - 4 * a * c;
 
            if (d < 0) {
                // no real roots
                System.out.println(0);
            }
            else if (d > 0){
                System.out.println(2);
                double ans1 = (-b - Math.sqrt(d)) / (2 * a);
                double ans2 = (-b + Math.sqrt(d)) / (2 * a);
                if (ans2 > ans1) {
                    System.out.format(FORMAT, ans1);
                    System.out.println();
                    System.out.format(FORMAT, ans2);
                }
                else {
                    System.out.format(FORMAT, ans2);
                    System.out.println();
                    System.out.format(FORMAT, ans1);
                }
 
            }
            else {
                System.out.println(1);
                System.out.format(FORMAT, (-b / (2 * a)));
            }
 
            return;
        }
 
 
 
    }
 
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double a = reader.nextInt();
        double b = reader.nextInt();
        double c = reader.nextInt();
 
        Main task = new Main();
        task.solve(a, b, c);
    }
}
