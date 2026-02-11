import java.util.*;

public class graph1 {

    // DFS using Stack (Iterative)
    public static void dfs(int[][] mat, int start, int v) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        System.out.println("\nDFS Traversal:");

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");

                // Push adjacent vertices in reverse order
                for (int i = v - 1; i >= 0; i--) {
                    if (mat[node][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int v = sc.nextInt();

        int[][] mat = new int[v][v];

        System.out.println("Enter number of edges:");
        int e = sc.nextInt();

        System.out.println("Enter edges (source destination):");

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            if (s >= 0 && s < v && d >= 0 && d < v) {
                mat[s][d] = 1;
                mat[d][s] = 1;  // Undirected graph
            } else {
                System.out.println("Invalid edge! Enter again.");
                i--;
            }
        }

        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        // DFS Call
        System.out.println("\nEnter starting vertex for DFS:");
        int start = sc.nextInt();

        dfs(mat, start, v);

        sc.close();
    }
}