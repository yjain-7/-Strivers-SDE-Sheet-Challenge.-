import java.util.*;

public class Bipartite {

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {

        // Write your code here
        if (edges == null || edges.size() == 0) return true;

        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
        int n = edges.size();
        for (int i = 0; i < n; i++) {
            adj_list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < edges.get(i).size(); j++) {
                if (edges.get(i).get(j) == 1 && i != j) {
                    adj_list.get(i).add(j);
                    adj_list.get(j).add(i);
                }
            }
        }

        int[] visited = new int[adj_list.size()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < adj_list.size(); i++) {
            if (visited[i] == -1) {
                int color = 0;
                queue.add(i);
                visited[i] = color;
                while (!queue.isEmpty()) {
                    int node = queue.remove();
                    for (int neighbour : adj_list.get(node)) {
                        if (visited[neighbour] == -1) {
                            visited[neighbour] = 1 - color;
                            queue.add(neighbour);
                        } else if (visited[neighbour] == visited[node]) {
                            return false;
                        }
                    }
                    color = 1 - color;
                }
            }
        }
        return true;
    }
}
/*---------------DFS--------------------------
import java.util.*;

public class Solution {
    public static boolean DFS(int node, ArrayList<ArrayList<Integer>> adj_list, int[] colors, int color) {
        colors[node] = color;

        for (int neighbour : adj_list.get(node)) {
            if (colors[neighbour] == -1) {
                if (!DFS(neighbour, adj_list, colors, 1 - color)) {
                    return false;
                }
            } else if (colors[node] == colors[neighbour]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> adjacencyMatrix) {
        if (adjacencyMatrix == null || adjacencyMatrix.size() == 0) {
            return true;
        }

        int n = adjacencyMatrix.size();
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj_list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adjacencyMatrix.get(i).size(); j++) {
                if (adjacencyMatrix.get(i).get(j) == 1 && i != j) {
                    adj_list.get(i).add(j);
                    adj_list.get(j).add(i);
                }
            }
        }

        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!DFS(i, adj_list, colors, 0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
 */