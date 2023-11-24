import java.io.*;
import java.util.*;
 
public class Main implements Runnable {
    private void solve() throws IOException {
        long a, b, c;
        a = nextInt();
        b = nextInt();
        c = nextInt();
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    out.println (-1);
                }
                else out.println (0);
            }
            else {
                out.println (1);
                out.println ((-c + 0.) / b);
            }
        }
        else {
            long d = b * b - 4 * a * c;
            if (d < 0) {
                out.println (0);
            }
            else if (d == 0) {
                out.println (1);
                out.println ((-b + 0.) / (2 * a));
            }
            else {
                out.println (2);
                double ans[] = {(-b + Math.sqrt (d)) / (2 * a), (-b - Math.sqrt (d)) / (2 * a)};
                Arrays.sort (ans);
                out.println (ans[0]);
                out.println (ans[1]);
            }
        }
    }
    
    //-------------------------------
 
    public static void main(String[] args) {
        new Main().run();
    }
 
    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;
 
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            out = new PrintWriter(System.out);
            solve();
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
 
    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
 
    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
 
    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
 
    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine());
        }
        return tokenizer.nextToken();
    }
}
 
class StopWatch {
    private final long start = System.currentTimeMillis();
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.;
    }
}
