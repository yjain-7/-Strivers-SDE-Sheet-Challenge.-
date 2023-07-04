import java.util.*;
import java.io.*;

public class TopologicalSort {
    public static void DFS(ArrayList<ArrayList<Integer>> adj_list, int[] visited, int node, Stack<Integer> stack) {
        visited[node] = 1;
        for (int i : adj_list.get(node)) {
            if (visited[i] == 0) {
                DFS(adj_list, visited, i, stack);
            }
        }

        stack.add(node);
    }

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj_list.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int U = edges.get(i).get(0);
            int V = edges.get(i).get(1);

            adj_list.get(U).add(V);
        }
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[adj_list.size()];

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                DFS(adj_list, visited, i, stack);
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while (!stack.isEmpty()) {
            answer.add(stack.pop());
        }
        return answer;
    }
}

// --------Kahn's Algorithm-----------
/*
 * import java.util.* ;
 * import java.io.*;
 * //Kahn's Algorithm
 * public class Solution
 * {
 * public static ArrayList<Integer>
 * topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e)
 * {
 * // Write your code here
 * ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
 * for(int i = 0 ; i < v; i++){
 * adj_list.add(new ArrayList<>());
 * }
 * 
 * for(int i = 0 ; i < e; i++){
 * int U = edges.get(i).get(0);
 * int V = edges.get(i).get(1);
 * 
 * adj_list.get(U).add(V);
 * }
 * 
 * int[] indegree = new int[v];
 * for(int i = 0 ; i < v; i++){
 * for(int node : adj_list.get(i)){
 * indegree[node]++;
 * }
 * }
 * 
 * Queue<Integer> queue = new LinkedList<>();
 * for(int i = 0 ; i < v; i++){
 * if(indegree[i] == 0){
 * queue.add(i);
 * }
 * }
 * 
 * ArrayList<Integer> answer = new ArrayList<>();
 * while(!queue.isEmpty()){
 * int node = queue.remove();
 * answer.add(node);
 * for(int i : adj_list.get(node)){
 * indegree[i]--;
 * if(indegree[i] == 0){
 * queue.add(i);
 * }
 * }
 * }
 * 
 * return answer;
 * }
 * }
 * 
 */
