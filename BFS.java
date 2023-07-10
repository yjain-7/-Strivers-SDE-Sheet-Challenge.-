import java.util.* ;
import java.io.*; 
import java.util.Queue;

public class BFS {
	public static ArrayList<Integer> BFS(int vertex, int[][] edges) {
        // BFS Traversal
        // Time Complexity: O(V + E)
        // Space Complexity: O(V)
        List<Set<Integer>> adj = new ArrayList<>(vertex);
        for (int i = 0; i < vertex; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        ArrayList<Integer> bfs = new ArrayList<>();
        // visited array
        boolean[] visited = new boolean[vertex];
        // Since the graph is disconnected
        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                // BFS Traversal
                // queue
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    if (visited[curr]) continue;
                    visited[curr] = true;
                    bfs.add(curr);
                    for (int j : adj.get(curr)) {
                        if (!visited[j])
                            queue.offer(j);
                    }
                }
            }
        }
        return bfs;
    }
}

