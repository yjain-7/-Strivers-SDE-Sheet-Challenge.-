//using BFS
import java.util.*;

public class CycleDetectionUndirectedGraph {
    static class Pair{
        int node;
        int parent;
        Pair(int _node, int _parent){
            node = _node;
            parent = _parent;
        }
    }
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            adj_list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;

            adj_list.get(u).add(v);
            adj_list.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        Queue<Pair> queue = new LinkedList<>();
        // queue.add(new Pair(1, -1));
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                queue.add(new Pair(i,-1));
                while(!queue.isEmpty()){
                    int node = queue.peek().node;
                    int parent_node = queue.peek().parent;
                    queue.remove();
                    visited[node] = true;
                    for(int neighbour : adj_list.get(node)){
                        if(visited[neighbour] == false){
                            queue.add(new Pair(neighbour, node));
                        }else if(parent_node != neighbour){
                            return "Yes";
                        }
                    }
                }
            }
        }
        return "No";
    }
}

/*
 * using DFS
 * import java.util.*;
public class Solution {
    public static boolean DFS(int node, int parent, ArrayList<ArrayList<Integer>> adj_list, boolean[] visited){
        visited[node] = true;
        
        for(int adj_node : adj_list.get(node)){
            if(!visited[adj_node]){
                if(DFS(adj_node, node, adj_list, visited))
                    return true;
            }else if(parent != adj_node){
                return true;
            }
        }
        
        return false;
    }
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            adj_list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;

            adj_list.get(u).add(v);
            adj_list.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                if(DFS(i, -1, adj_list, visited)){
                    return "Yes";
                }
            }
        }

        return "No";
    }
    
}
 */