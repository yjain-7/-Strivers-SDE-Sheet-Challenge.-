import java.util.*;
import java.io.*;

public class Dijkstra {
    static class Pair {
        int node;
        int distance;

        Pair(int n, int dt) {
            node = n;
            distance = dt;
        }
    }

    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int source) {
        // Write your code here.
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < edges; i++) {
            int u = vec.get(i).get(0);
            int v = vec.get(i).get(1);
            int dt = vec.get(i).get(2);

            adjList.get(u).add(new Pair(v, dt));
            adjList.get(v).add(new Pair(u, dt));
        }

        ArrayList<Integer> distance = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            distance.add(Integer.MAX_VALUE);

        distance.set(0, 0);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int dt = pq.peek().distance;

            pq.remove();

            for (Pair p : adjList.get(node)) {
                int adjNode = p.node;
                int adjWt = p.distance;

                if (dt + adjWt < distance.get(adjNode)) {
                    distance.set(adjNode, dt + adjWt);
                    pq.add(new Pair(adjNode, distance.get(adjNode)));
                }
            }
        }

        return distance;

    }
}