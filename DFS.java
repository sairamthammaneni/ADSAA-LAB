import java.util.ArrayList;
import java.util.List;

class DFS {
    // Recursive function for DFS traversal
    static void dfsRec(List<List<Integer>> adj, boolean[] visited, int s) {
        // Mark the current vertex as visited
        visited[s] = true;
        // Print the current vertex
        System.out.print(s + " ");
        // Recursively visit all adjacent vertices that are not visited yet
        for (int i : adj.get(s)) {
            if (!visited[i]) {
                dfsRec(adj, visited, i);
            }
        }
    }

    static void dfs(List<List<Integer>> adj, int s) {
        boolean[] visited = new boolean[adj.size()];
        dfsRec(adj, visited, s);
    }

    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph
        // Create an adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Define the edges of the graph
        int[][] edges = { { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3
        }, { 2, 4 } };
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }
        dfs(adj, 0);
    }
}
