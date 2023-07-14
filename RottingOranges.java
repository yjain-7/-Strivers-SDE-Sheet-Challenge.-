import java.util.*;
import java.util.Queue;

public class RottingOranges {
	static class Pair{
		int r;
		int c;
		int t;
		Pair(int r, int c, int t){
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	public static int minTimeToRot(int[][] grid, int n, int m) {
		// Write your code here.
		Queue<Pair> queue = new LinkedList<>();
		int[][] visited = new int[n][m];
		int countFresh = 0;
		for(int i = 0 ; i < n; i++){
			for(int j = 0; j < m; j++){
				if(grid[i][j] == 2){
					queue.add(new Pair(i, j, 0));
					visited[i][j] = 2;
				}
				else if(grid[i][j] == 1) countFresh++;
			}
		}

		int[] dr = {1,0,-1,0};
		int[] dc = {0,1,0,-1};
		int time = 0;
		int count = 0;
		while(!queue.isEmpty()){
			int row = queue.peek().r;
			int col = queue.peek().c;
			int t = queue.peek().t;
			queue.remove();
			time = Math.max(t, time);

			for(int i = 0; i < 4; i++){
				int nrow = dr[i] + row;
				int ncol = dc[i] + col;
				
				if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m){
					if(grid[nrow][ncol] == 1 && visited[nrow][ncol] != 2){
						queue.add(new Pair(nrow, ncol, t+1));
						visited[nrow][ncol] = 2;
						count++;
					}
				}
			}
		}
		return (countFresh == count) ? time : -1;
	}

}