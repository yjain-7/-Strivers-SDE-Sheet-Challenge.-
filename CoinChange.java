import java.util.*;
//Memoization
public class CoinChange {
	public static long helper(int ind, int target, int[] arr, long[][] dp){
		if(target == 0){
			return 1;
		}
		if(ind == -1 || target < 0) return 0;

		if(dp[ind][target] != -1) return dp[ind][target];

		long notpick = helper(ind-1, target, arr, dp);
		long pick = helper(ind, target - arr[ind], arr, dp);

		return dp[ind][target] = notpick + pick;
	}

	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here		
		int n = denominations.length;
		long[][] dp = new long[n][value + 1];
		for(long[] row : dp){
			Arrays.fill(row, -1);
		}
		return helper(n-1, value, denominations, dp);
	}
	
}

/* Tabulation
 * import java.util.*;
public class Solution {
    public static long countWaysToMakeChange(int denominations[], int value) {
        int n = denominations.length;
        long[][] dp = new long[n][value + 1];

        for (int ind = 0; ind < n; ind++) {
            for (int target = 0; target <= value; target++) {
                if (target == 0) {
                    dp[ind][target] = 1;
                } else {
                    long notpick = (ind > 0) ? dp[ind - 1][target] : 0;
                    long pick = 0;
                    if (denominations[ind] <= target) {
                        pick = dp[ind][target - denominations[ind]];
                    }
                    dp[ind][target] = notpick + pick;
                }
            }
        }

        return dp[n - 1][value];
    }
}

 */