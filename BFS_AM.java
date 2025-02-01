import java.util.*;

class BFS_AM {
    static void bfs(int[][] adj, int start) {
        boolean[] visited = new boolean[5];
        List<Integer> q = new ArrayList<>();
        q.add(start);
        visited[start] = true;
        int vis;
        while (!q.isEmpty()) {
            vis = q.get(0);
            System.out.print(vis + " ");
            q.remove(q.get(0));
            for (int i = 0; i < 5; i++) {
                if (adj[vis][i] == 1 && (!visited[i])) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int adj[][] = { { 0, 1, 1, 0, 0 }, { 1, 0, 1, 0, 0 }, { 0, 1, 0, 1, 1 },
                { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 } };
        bfs(adj, 0);
    }
}