import java.util.*;
import java.io.*;

public class ConnectedComponentsUnionFind {
    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        public void unionSet(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static List<List<Integer>> findConnectedComponents(int n, List<int[]> edges) {
        UnionFind uf = new UnionFind(n);
        // Unite nodes based on given edges
        for (int[] edge : edges) {
            uf.unionSet(edge[0], edge[1]);
        }

        Map<Integer, List<Integer>> components = new HashMap<>();
        // Create a map to collect connected components
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        // Convert the map to a list of components
        return new ArrayList<>(components.values());
    }

    public static void readGraph(List<int[]> edges, int[] n) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("graph.in"));
        String[] line = br.readLine().split(" ");
        n[0] = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        for (int k = 0; k < m; k++) {
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]) - 1; // convert to 0-based index
            int v = Integer.parseInt(line[1]) - 1;
            edges.add(new int[]{u, v});
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        List<int[]> edges = new ArrayList<>();
        int[] n = new int[1];
        readGraph(edges, n);

        List<List<Integer>> components = findConnectedComponents(n[0], edges);

        System.out.println("Componentele conexe sunt:");
        for (List<Integer> component : components) {
            for (int node : component) {
                System.out.print((node + 1) + " "); // print nodes 1-based
            }
            System.out.println();
        }
    }
}
