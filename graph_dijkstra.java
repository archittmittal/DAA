import java.util.*;
public class graph_dijkstra {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, dist;
        Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    public static void dijkstraWithPath(List<List<Edge>> adj, int src) {
        int n = adj.size();
        int[] dist = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[src] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;
            int d = node.dist;
            if (d > dist[u]) continue;
            for (Edge edge : adj.get(u)) {
                int v = edge.to;
                int w = edge.weight;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    prev[v] = u;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest paths to Akshay's house (node " + src + "):");
        for (int i = 0; i < n; i++) {
            if (i == src) continue;
            System.out.print("From node " + i + ": ");
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("No path");
                continue;
            }
            // Reconstruct path
            List<Integer> path = new ArrayList<>();
            for (int at = i; at != -1; at = prev[at]) path.add(at);
            Collections.reverse(path);
            for (int j = 0; j < path.size(); j++) {
                System.out.print(path.get(j));
                if (j != path.size() - 1) System.out.print(" -> ");
            }
            System.out.println(" | Distance: " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();
        System.out.println("Enter edges (u v w):");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new Edge(v, w));
        }
        System.out.print("Enter Akshay's house node (source): ");
        int src = sc.nextInt();
        dijkstraWithPath(adj, src);
    }
    
}
