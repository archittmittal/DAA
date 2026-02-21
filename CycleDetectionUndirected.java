import java.util.*;

public class CycleDetectionUndirected {

    static boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj))
                    return true;
            }
            else if (neighbor != parent) {
                return true;   // cycle detected
            }
        }

        return false;
    }

    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        System.out.println("Enter edges (u v):");

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            // undirected graph
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        if (isCycle(V, adj))
            System.out.println("Cycle exists");
        else
            System.out.println("No cycle");

        sc.close();
    }
}