import java.util.Scanner;

public class PermutationsBacktracking {

    static int n;
    static int[] stack = new int[100];

    static boolean accepted(int level) {
        for (int i = 1; i < level; ++i) {
            if (stack[level] == stack[i]) {
                return false;
            }
        }
        return true;
    }

    static void solve(int level) {
        if (level == n + 1) {
            for (int i = 1; i <= n; ++i) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; ++i) {
                stack[level] = i;
                if (accepted(level)) {
                    solve(level + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 1 2 3
        // 2 3 1

        n = 3; // n! = 1*2*3*...*n, n! permutations
        solve(1);
    }
}
