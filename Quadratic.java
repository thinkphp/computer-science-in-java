/*
 *  Compilation: javac Quadratic.java
 *  Execution  : java Quadratic a b c
 *
 *  Given a, b and c, solves for the roots of a*x^2 + b*c + c
 *  Assumes both roots are real valued. 
 *
 *  ironman@localhost$ java Quadratic 1.0 -1.0 -1.0
 *   1.618033988749895
 *  -0.6180339887498949
 *
 *  Remark: 1.6118... is the golden ratio
 */

public class Quadratic {

        public static void main(String[] args) {

                double a = Double.parseDouble(args[0]), 
                       b = Double.parseDouble(args[1]),
                       c = Double.parseDouble(args[2]),
                       discriminant = b*b - 4.0 * a * c;

                double sqroot = Math.sqrt(discriminant);

                double root1 = (-b + sqroot) / 2.0 * a,
                       root2 = (-b - sqroot) / 2.0 * a;

                System.out.println(root1);
                System.out.println(root2);     
                   
        }
}
