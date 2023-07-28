import java.util.*;

public class Main {

    public static int beauty(int n, int m, String s, Map<Integer, List<Integer>> edges) {
        int max = 0;
        try {
            for (int i = 1; i <= n; i++) {
                for (List<Integer> path : path(i, new ArrayList<>(), edges, s)) {
                    int mm = maxi(path, s);
                    if (mm > max) {
                        max = mm;
                    }
                }
            }
            return max;
        } catch (Exception e) {
            return -1;
        }
    }

    private static List<List<Integer>> path(int node, List<Integer> done, Map<Integer, List<Integer>> edges, String s) {
        if (done.contains(node)) {
            throw new Exception();
        }
        if (!edges.containsKey(node)) {
            return Arrays.asList(done);
        }
        List<List<Integer>> temp = new ArrayList<>();
        for (int i : edges.get(node)) {
            temp.addAll(path(i, done + Arrays.asList(node), edges, s));
        }
        return temp;
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
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (!edges.containsKey(x)) {
                edges.put(x, new ArrayList<>());
            }
            edges.get(x).add(y);
            if (!edges.containsKey(y)) {
                edges.put(y, new ArrayList<>());
            }
            edges.get(y).add(x);
        }
        System.out.println(beauty(n, m, s, edges));
    }
}
M