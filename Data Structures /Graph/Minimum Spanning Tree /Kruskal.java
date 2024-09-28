import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v, cost;

    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.cost, other.cost);
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int u) {
        if (u != parent[u]) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    public void unite(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}

public class Kruskal {
    public static void main(String[] args) {
        String inputFile = "apm.in";
        String outputFile = "apm.out";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String[] firstLine = br.readLine().split(" ");
            int N = Integer.parseInt(firstLine[0]);
            int M = Integer.parseInt(firstLine[1]);

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                String[] line = br.readLine().split(" ");
                int u = Integer.parseInt(line[0]);
                int v = Integer.parseInt(line[1]);
                int cost = Integer.parseInt(line[2]);
                edges.add(new Edge(u, v, cost));
            }

            Collections.sort(edges);

            UnionFind uf = new UnionFind(N + 1);  // N + 1 because nodes are 1-indexed
            List<Edge> mst = new ArrayList<>();
            int totalCost = 0;

            for (Edge edge : edges) {
                if (uf.find(edge.u) != uf.find(edge.v)) {
                    uf.unite(edge.u, edge.v);
                    mst.add(edge);
                    totalCost += edge.cost;
                }
            }

            bw.write(totalCost + "\n");
            bw.write(mst.size() + "\n");
            for (Edge edge : mst) {
                bw.write(edge.u + " " + edge.v + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
