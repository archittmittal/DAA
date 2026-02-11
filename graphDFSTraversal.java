import java.util.*;

public class graphDFSTraversal {

    public static boolean dfs(int[][] mat, int start, int v, int end, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");

                if (node == end) {
                    return true;  // End node found
                }

                for (int i = v - 1; i >= 0; i--) {
                    if (mat[node][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
        return false;
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
                mat[d][s] = 1;   // Undirected
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

        System.out.println("\nEnter starting vertex:");
        int start = sc.nextInt();

        System.out.println("Enter target node:");
        int end = sc.nextInt();

        // Validation
        if (start < 0 || start >= v || end < 0 || end >= v) {
            System.out.println("Invalid start or end vertex!");
            return;
        }

        boolean[] visited = new boolean[v];

        System.out.println("\nDFS Traversal:");

        boolean found = dfs(mat, start, v, end, visited);

        // If not found in start's component, check remaining components
        if (!found) {
            for (int i = 0; i < v; i++) {
                if (!visited[i]) {
                    if (dfs(mat, i, v, end, visited)) {
                        found = true;
                        break;
                    }
                }
            }
        }

        if (found)
            System.out.println("\nEnd node found!");
        else
            System.out.println("\nEnd node not reachable in graph.");

        sc.close();
    }
}
