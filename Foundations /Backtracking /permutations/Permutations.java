import java.io.*;
import java.util.Scanner;

public class Permutations {
    private static final int MAX = 10;
    private static int n;
    private static int[] stack = new int[MAX];
    private static int level;
    private static BufferedWriter fout;

    public static void main(String[] args) {
        try {
            fout = new BufferedWriter(new FileWriter("perm.out"));
            read("perm.in");
            solve();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            n = scanner.nextInt();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        level = 1;
        stack[level] = 1;
        level = 2;
        back();
    }

    private static void init() {
        stack[level] = 0;
    }

    private static void back() {
        int HS;

        init();

        while (level > 0) {
            do {
            } while ((HS = have_next()) == 1 && !isValid());

            if (HS == 1) {
                if (solution()) {
                    printSolution("perm.out");
                } else {
                    level = level + 1;
                    init();
                }
            } else {
                level = level - 1;
            }
        }
    }

    private static boolean isValid() {
        for (int i = 1; i <= level - 1; i++) {
            if (stack[i] == stack[level]) {
                return false;
            }
        }
        return true;
    }

    private static boolean solution() {
        return level == n;
    }

    private static void printSolution(String filename) {
        try {
            for (int i = 1; i <= n; i++) {
                System.out.print(stack[i] + " ");
                fout.write(stack[i] + " ");
            }
            System.out.println();
            fout.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int have_next() {
        if (stack[level] < n) {
            stack[level]++;
            return 1;
        }
        return 0;
    }
}
