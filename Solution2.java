import java.util.*;

public class Solution2 {
    public static int beauty(int n, int m, String s, List<Integer> x, List<Integer> y) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < m; i++) {
            if (edges.containsKey(x.get(i))) {
                edges.get(x.get(i)).add(y.get(i));
            } else {
                edges.put(x.get(i), new ArrayList<>(Arrays.asList(y.get(i))));
            }
        }
        
        int max = 0;
        try {
            for (int i = 1; i <= n; i++) {
                for (List<Integer> path : path(i, new ArrayList<>(), edges)) {
                    int mm = maxi(path, s);
                    if (mm > max) {
                        max = mm;
                    }
                }
            }
            return max;
        } catch (RuntimeException e) {
            return -1;
        }
    }

    private static List<List<Integer>> path(int node, List<Integer> done, Map<Integer, List<Integer>> edges) {
        List<List<Integer>> result = new ArrayList<>();
        if (done.contains(node)) {
            return result; // Return an empty list to prevent adding this path to the result
        }
    
        List<Integer> currentPath = new ArrayList<>(done);
        currentPath.add(node);
    
        if (!edges.containsKey(node)) {
            result.add(currentPath);
            return result;
        }
    
        for (int i : edges.get(node)) {
            result.addAll(path(i, new ArrayList<>(currentPath), edges)); // Update done list in the recursive call
        }
    
        // Add path if it starts and ends at the same node (leaf node)
        if (currentPath.get(currentPath.size() - 1) == node) {
            result.add(currentPath);
        }
    
        return result;
    }
    

    private static int maxi(List<Integer> lis, String s) {
        if (lis.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> k = new HashMap<>();
        int ma = 0;
        for (int i : lis) {
            char kk = s.charAt(i - 1);
            if (!k.containsKey(kk)) {
                k.put(kk, 1);
            } else {
                k.put(kk, k.get(kk) + 1);
            }
            if (k.get(kk) > ma) {
                ma = k.get(kk);
            }
        }
        return ma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            x.add(scanner.nextInt());
            y.add(scanner.nextInt());
        }
        System.out.println(beauty(n, m, s, x, y));
    }
}
