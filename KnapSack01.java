import java.util.ArrayList;

public class KnapSack01 {
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
		int[][] dp = new int[n][w+1];
		for(int wt = weights.get(0) ; wt <= w; wt++){
			dp[0][wt] = values.get(0); 
		}

		for(int ind = 1; ind < n; ind++){
			for(int wt = 0 ; wt <= w; wt++){
				int notPick = dp[ind-1][wt];
				int pick = Integer.MIN_VALUE;
				if(weights.get(ind) <= wt){
					pick = values.get(ind) + dp[ind-1][wt - weights.get(ind)];
				}

				dp[ind][wt] = Math.max(notPick, pick);
			}
		}

		return dp[n-1][w];
	}
}