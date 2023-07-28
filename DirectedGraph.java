import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraph {
    private Map<Integer, List<Integer>> graph;

    public DirectedGraph() {
        graph = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        graph.putIfAbsent(source, new ArrayList<>());
        graph.get(source).add(destination);
    }

    public Map<Integer, List<List<Integer>>> findAllPaths() {
        Map<Integer, List<List<Integer>>> allPaths = new HashMap<>();
        for (int node : graph.keySet()) {
            allPaths.put(node, new ArrayList<>());
            dfs(node, new ArrayList<>(), allPaths.get(node));
        }
        
        // Check for isolated nodes and add empty paths for them
        for (int node : graph.keySet()) {
            if (!allPaths.containsKey(node)) {
                allPaths.put(node, new ArrayList<>());
            }
        }
        
        return allPaths;
    }

    private void dfs(int node, List<Integer> path, List<List<Integer>> paths) {
        path.add(node);
        if (!graph.containsKey(node)) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int neighbor : graph.get(node)) {
            dfs(neighbor, new ArrayList<>(path), paths);
        }
    }

    public static void main(String[] args) {
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(1, 3);
        directedGraph.addEdge(3, 4);
        directedGraph.addEdge(4, 5);

        Map<Integer, List<List<Integer>>> result = directedGraph.findAllPaths();
        for (int node : result.keySet()) {
            System.out.println("Paths from Node " + node + ":");
            for (List<Integer> path : result.get(node)) {
                System.out.println(String.join(" -> ", path.stream().map(Object::toString).toArray(String[]::new)));
            }
            System.out.println();
        }
    }
}
