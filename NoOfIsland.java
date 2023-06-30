public class NoOfIsland {
    public static int getTotalIslands(int[][] mat) {
        // Your code goes here
        int count = 0;
        int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { 1, -1 }, { 1, 1 }, { -1, 1 } };
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    DFS(mat, i, j, n, m, directions);
                    count++;
                }
            }
        }
        return count;
    }

    public static void DFS(int[][] mat, int i, int j, int n, int m, int[][] directions) {
        mat[i][j] = -1;
        for (int[] direction : directions) {
            int ithIndex = i + direction[0];
            int jthIndex = j + direction[1];

            if (ithIndex >= 0 && jthIndex >= 0 && ithIndex < n && jthIndex < m && mat[ithIndex][jthIndex] == 1) {
                DFS(mat, ithIndex, jthIndex, n, m, directions);
            }
        }
    }
}