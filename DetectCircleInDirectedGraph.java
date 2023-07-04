import java.util.ArrayList;

public class DetectCircleInDirectedGraph {
    public static boolean DFS(ArrayList<ArrayList<Integer>> adj_list, int[] visited, int[] path, int node) {
        visited[node] = 1;
        path[node] = 1;
        for (int i : adj_list.get(node)) {
            if (visited[i] == 0) {
                if (DFS(adj_list, visited, path, i)) {
                    return true;
                }
            } else if (path[i] == 1) {
                return true;
            }
        }
        path[node] = 0;
        return false;
    }

    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj_list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            adj_list.get(u).add(v);
            // adj_list.get(v).add(u);
        }

        int[] visited = new int[n + 1];
        int[] path = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                if (DFS(adj_list, visited, path, i)) {
                    return true;
                }
            }
        }
        return false;

    }
}
