import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pttrung
 */
public class B {
 
    public static void main(String[] args) {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        double A = in.nextInt();
        double B = in.nextInt();
        double C = in.nextInt();
        if (A != 0) {
            double delta = B * B - (4 * A * C);
            if (delta < 0) {
                out.println(0);
            } else {
                double first = (-B + Math.sqrt(delta)) / (2 * A);
                double second = (-B - Math.sqrt(delta)) / (2 * A);
                if (first == second) {
                    out.println(1);
                    out.println(first);
                } else {
                    out.println(2);
                    out.printf("%.5f\n", first > second ? second : first);
 
                    out.printf("%.5f", first > second ? first : second);
                }
            }
        } else if (B != 0) {
            out.println(1);
            out.printf("%.5f", (double) -C / B);
        } else {
            if (C != 0) {
                out.println(0);
            }else {
                out.println(-1);
            }
        }
        out.close();
    }
 
    public static int countTwo(int val) {
        int result = 0;
        while (val > 0 && val % 2 == 0) {
            val /= 2;
            result++;
        }
        return result;
    }
 
    public static int countFive(int val) {
        int result = 0;
        while (val > 0 && val % 5 == 0) {
            val /= 5;
            result++;
        }
        return result;
    }
 
    public static long count(long two, long five) {
        return Math.min(two, five);
    }
 
    public double pow(double a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        double val = pow(a, b / 2);
        if (b % 2 == 0) {
            return val * val;
        } else {
            return val * val * a;
        }
    }
 
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
 
    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
 
    static class Scanner {
 
        BufferedReader br;
        StringTokenizer st;
 
        public Scanner() {
            // System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        public String next() {
 
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public double nextDouble() {
            return Double.parseDouble(next());
        }
 
        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
 
        public boolean endLine() {
            try {
                String next = br.readLine();
                while (next != null && next.trim().isEmpty()) {
                    next = br.readLine();
                }
                if (next == null) {
                    return true;
                }
                st = new StringTokenizer(next);
                return st.hasMoreTokens();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}
