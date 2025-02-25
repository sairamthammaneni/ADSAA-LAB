import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list representation
@SuppressWarnings("unused")
class Graph {
    private int V, E; // No. of vertices & Edges respectively
    private LinkedList<Integer> adj[]; // Adjacency List

    // Count is number of biconnected components. time is used to find discovery times
    static int count = 0, time = 0;

    class Edge {
        int u;
        int v;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    // Constructor
    @SuppressWarnings({ "unchecked", "rawtypes" })
    Graph(int v) {
        V = v;
        E = 0;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    // A recursive function that finds and prints biconnected components using DFS traversal
    void BCCUtil(int u, int disc[], int low[], LinkedList<Edge> st, int parent[]) {

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;
        int children = 0;

        // Go through all vertices adjacent to this
        Iterator<Integer> it = adj[u].iterator();
        while (it.hasNext()) {
            int v = it.next(); // v is current adjacent of 'u'

            // If v is not visited yet, then recur for it
            if (disc[v] == -1) {
                children++;
                parent[v] = u;

                // store the edge in stack
                st.add(new Edge(u, v));
                BCCUtil(v, disc, low, st, parent);

                // Check if the subtree rooted with 'v' has a connection to one of the ancestors of 'u'
                if (low[u] > low[v])
                    low[u] = low[v];

                // If u is an articulation point, pop all edges from stack till u -- v
                if ((disc[u] == 1 && children > 1) || (disc[u] > 1 && low[v] >= disc[u])) {
                    System.out.println("Biconnected Component:");
                    while (st.getLast().u != u || st.getLast().v != v) {
                        System.out.print(st.getLast().u + "--" + st.getLast().v + " ");
                        st.removeLast();
                    }
                    System.out.println(st.getLast().u + "--" + st.getLast().v + " ");
                    st.removeLast();

                    count++;
                }
            }

            // Update low value of 'u' only if 'v' is still in stack (i.e., it's a back edge, not cross edge)
            else if (v != parent[u] && disc[v] < disc[u]) {
                if (low[u] > disc[v])
                    low[u] = disc[v];

                st.add(new Edge(u, v));
            }
        }
    }

    // The function to do DFS traversal. It uses BCCUtil()
    void BCC() {
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        LinkedList<Edge> st = new LinkedList<Edge>();

        // Initialize disc and low, and parent arrays
        for (int i = 0; i < V; i++) {
            disc[i] = -1;
            low[i] = -1;
            parent[i] = -1;
        }

        // Call the recursive helper function to find BCCs
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1)
                BCCUtil(i, disc, low, st, parent);

            // If stack is not empty, pop all edges from stack
            while (st.size() > 0) {
                System.out.print(st.getLast().u + "--" + st.getLast().v + " ");
                st.removeLast();
            }
            if (st.size() > 0) {
                System.out.println();
                count++;
            }
        }
    }

    @SuppressWarnings("static-access")
    public static void main(String args[]) {
        Graph g = new Graph(12);
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 3);
        g.addEdge(1, 5);
        g.addEdge(5, 1);
        g.addEdge(0, 6);
        g.addEdge(6, 0);
        g.addEdge(5, 6);
        g.addEdge(6, 5);
        g.addEdge(5, 7);
        g.addEdge(7, 5);
        g.addEdge(5, 8);
        g.addEdge(8, 5);
        g.addEdge(7, 8);
        g.addEdge(8, 7);
        g.addEdge(8, 9);
        g.addEdge(9, 8);
        g.addEdge(10, 11);
        g.addEdge(11, 10);

        g.BCC();

        System.out.println("Above are " + g.count + " biconnected components in graph");
    }
}
