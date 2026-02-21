import java.util.*;

public class bipartite_graph {
    int[] queue;
    int front = -1;
    int rear = -1;

    public bipartite_graph(int n){
        queue = new int[n];
    }

    private void resetQueue(){
        front = -1;
        rear = -1;
    }

    public void enqueue(int val){
        if(front == -1 && rear == -1){
            front = 0;
            rear = 0;
            queue[rear] = val;
        } else {
            rear++;
            queue[rear] = val;
        }
    }

    public int dequeue(){
        int val = queue[front];
        if(front == rear){
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        return val;
    }

    public boolean isEmpty(){
        return front == -1 && rear == -1;
    }

    // BFS traversal used for bipartite checking
    private boolean bfsTraversal(List<List<Integer>> adj, int start, boolean[] visited, int[] color, List<Integer> order){
        resetQueue();
        enqueue(start);
        visited[start] = true;
        color[start] = 0;

        while(!isEmpty()){
            int u = dequeue();
            order.add(u);

            for(int nei : adj.get(u)){
                if(!visited[nei]){
                    visited[nei] = true;
                    color[nei] = 1 - color[u];
                    enqueue(nei);
                } else if(color[nei] == color[u]){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartite(List<List<Integer>> adj, int v){
        int[] color = new int[v];
        Arrays.fill(color, -1);
        boolean[] visited = new boolean[v];

        for(int start = 0; start < v; start++){
            if(visited[start]) continue;

            List<Integer> order = new ArrayList<>();
            boolean ok = bfsTraversal(adj, start, visited, color, order);
            if(!ok) return false;

            // If you want to see traversal:
            System.out.println("BFS from " + start + ": " + order);
        }
        return true;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices");
        int v = sc.nextInt();

        System.out.println("Enter the number of edges");
        int e = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++) adj.add(new ArrayList<>());

        System.out.println("Enter vertex between edges");
        for(int i = 0; i < e; i++){
            int s = sc.nextInt();
            int d = sc.nextInt();
            if(s < 0 || s >= v || d < 0 || d >= v){
                System.out.println("Invalid vertex in edge: " + s + " " + d);
                return;
            }
            adj.get(s).add(d);
            adj.get(d).add(s);
        }

        bipartite_graph bg = new bipartite_graph(v);
        boolean result = bg.isBipartite(adj, v);
        System.out.println(result ? "Graph is Bipartite" : "Graph is NOT Bipartite");
    }
}

// if length of cycle is odd -- never bipertiate
// length even -- bipertite
