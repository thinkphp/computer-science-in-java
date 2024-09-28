import java.util.*;

public class ConnectedComponents {
    public static void readInput(List<List<Integer>> graph, Scanner scanner) {
        System.out.print("Numărul de noduri: ");
        int n = scanner.nextInt();
        System.out.print("Numărul de relații: ");
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Introduceți relațiile (i, j):");
        for (int k = 0; k < m; ++k) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u - 1).add(v - 1);
            graph.get(v - 1).add(u - 1);
        }
    }

    public static void dfs(List<List<Integer>> graph, int node, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, component);
            }
        }
    }

    public static List<List<Integer>> findConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < graph.size(); ++i) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(graph, i, visited, component);
                components.add(component);
            }
        }

        return components;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        readInput(graph, scanner);

        List<List<Integer>> components = findConnectedComponents(graph);

        System.out.println("Componentele conexe sunt:");
        for (List<Integer> component : components) {
            for (int node : component) {
                System.out.print((node + 1) + " ");  // Afișăm nodurile 1-based
            }
            System.out.println();
        }

        scanner.close();
    }
}
