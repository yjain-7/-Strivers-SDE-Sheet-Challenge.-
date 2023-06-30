public class FloodFill
{
    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {
        // Write your code here
        int n = image.length;
        int m = image[0].length;
        int currColor = image[x][y];
        int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}};
        boolean[][] visited = new boolean[n][m];
        DFS(image, x, y, newColor, currColor, visited, directions);

        return image;
    }
    public static void DFS(int[][] image, int x, int y, int newColor, int currColor, boolean[][] visited, int[][] directions){
        if(image[x][y] != currColor) return;
        int n = image.length;
        int m = image[0].length;
        image[x][y] = newColor;
        visited[x][y] = true;

        for(int[] direction : directions){
            int ithIndex = (x + direction[0]);
            int jthIndex = (y + direction[1]);

            if(ithIndex >= 0 && jthIndex >= 0 && ithIndex < n && jthIndex < m && !visited[ithIndex][jthIndex]){
                DFS(image, ithIndex, jthIndex, newColor, currColor, visited, directions);
            }
        }
    }
}

