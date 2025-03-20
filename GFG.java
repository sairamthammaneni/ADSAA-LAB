import java.io.*;
import java.util.*;

class GFG {

    static class AdjListNode {
        int vertex, weight;

        AdjListNode(int v, int w) {
            vertex = v;
            weight = w;
        }

        int getVertex() {
            return vertex;
        }

        int getWeight() {
            return weight;
        }
    }

    // Function to find the shortest distance of all the vertices from the source vertex S.
    public static int[] dijkstra(int V, ArrayList<ArrayList<AdjListNode>> graph, int src) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        PriorityQueue<AdjListNode> pq = new PriorityQueue<>(Comparator.comparingInt(AdjListNode::getWeight));
        pq.add(new AdjListNode(src, 0));

        while (!pq.isEmpty()) {
            AdjListNode current = pq.poll();

            // Check the neighbors of the current node
            for (AdjListNode neighbor : graph.get(current.getVertex())) {
                int newDist = distance[current.getVertex()] + neighbor.getWeight();
                if (newDist < distance[neighbor.getVertex()]) {
                    distance[neighbor.getVertex()] = newDist;
                    pq.add(new AdjListNode(neighbor.getVertex(), newDist));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int V = 9;
        ArrayList<ArrayList<AdjListNode>> graph = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        graph.get(0).add(new AdjListNode(1, 4));
        graph.get(0).add(new AdjListNode(7, 8));
        graph.get(1).add(new AdjListNode(2, 8));
        graph.get(1).add(new AdjListNode(7, 11));
        graph.get(1).add(new AdjListNode(0, 7));
        graph.get(2).add(new AdjListNode(1, 8));
        graph.get(2).add(new AdjListNode(3, 7));
        graph.get(2).add(new AdjListNode(8, 2));
        graph.get(2).add(new AdjListNode(5, 4));
        graph.get(3).add(new AdjListNode(2, 7));
        graph.get(3).add(new AdjListNode(4, 9));
        graph.get(3).add(new AdjListNode(5, 14));
        graph.get(4).add(new AdjListNode(3, 9));
        graph.get(4).add(new AdjListNode(5, 10));
        graph.get(5).add(new AdjListNode(4, 10));
        graph.get(5).add(new AdjListNode(6, 2));
        graph.get(6).add(new AdjListNode(5, 2));
        graph.get(6).add(new AdjListNode(7, 1));
        graph.get(6).add(new AdjListNode(8, 6));
        graph.get(7).add(new AdjListNode(0, 8));
        graph.get(7).add(new AdjListNode(1, 11));
        graph.get(7).add(new AdjListNode(6, 1));
        graph.get(7).add(new AdjListNode(8, 7));
        graph.get(8).add(new AdjListNode(2, 2));
        graph.get(8).add(new AdjListNode(6, 6));
        graph.get(8).add(new AdjListNode(7, 1));

        int source = 0;
        int[] distance = dijkstra(V, graph, source);

        // Printing the Output
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "         " + distance[i]);
        }
    }
}
