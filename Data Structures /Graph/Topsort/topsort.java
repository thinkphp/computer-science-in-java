import java.io.*;
import java.util.*;

public class TopologicalSort {
    private static int nodes;
    private static int edges;
    private static int[][] matrix;
    private static boolean[] explored;
    private static List<Integer> sol = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        topsort();
    }

    private static void topsort() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("topsort.in"));

        // Grab the number of nodes and edges
        String[] firstLine = file.readLine().split(" ");
        nodes = Integer.parseInt(firstLine[0]);
        edges = Integer.parseInt(firstLine[1]);

        // Define the matrix
        matrix = new int[nodes + 1][nodes + 1];
        explored = new boolean[nodes + 1];

        for (int i = 0; i < edges; i++) {
            String[] line = file.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            matrix[x][y] = 1;
        }

        file.close();

        for (int i = 1; i <= nodes; i++) {
            if (!explored[i]) {
                dfs(i);
            }
        }

        Collections.reverse(sol);
        System.out.println(sol);
    }

    private static void dfs(int node) {
        explored[node] = true;
        for (int k = 1; k <= nodes; k++) {
            if (!explored[k] && matrix[node][k] == 1) {
                dfs(k);
            }
        }
        sol.add(node);
    }
}
