import java.util.*;
//Memoization
public class LCS {

	public static int lcs(String s, String t) {
		//Your code goes here
		int n = s.length();
		int m = t.length();
		int[][] dp = new int[n+1][m+1];
		for(int[] row : dp){
			Arrays.fill(row, -1);
		}
		return f(n, m, s, t, dp);
    }

	public static int f(int i, int j, String s, String t, int[][] dp){
		if(i == 0 || j == 0){
			return 0;
		}
		if(dp[i][j] != -1) return dp[i][j];
		if(s.charAt(i-1) == t.charAt(j-1)){
			return dp[i][j] =  1 + f(i-1, j-1, s, t,dp);
		}

		return dp[i][j] = Math.max(f(i-1, j, s, t, dp), f(i, j-1, s, t, dp));
	}

}
/*
 * Tabulation
 * import java.util.*;
public class Solution {

	public static int lcs(String s, String t) {
		//Your code goes here
		int n = s.length();
		int m = t.length();
		int[][] dp = new int[n+1][m+1];


		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				if(s.charAt(i-1) == t.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[n][m];

        //Printing LCS
        String ans = "";
		int i = n;
		int j = m;
		while(i > 0 && j > 0){
			if(s.charAt(i-1) == t.charAt(j-1)){
				ans = s.charAt(i) + ans;
				i--;
				j--;
			}else if(dp[i-1][j] > dp[i][j-1]){
				i--;
			}else{
				j--;
			}
		}
    }
}
//Space Optimizaition
import java.util.*;
public class Solution {

	public static int lcs(String s, String t) {
		//Your code goes here
		int n = s.length();
		int m = t.length();
		// int[][] dp = new int[n+1][m+1];
		int[] prev = new int[m+1];
		int[] curr = new int[m+1];


		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				if(s.charAt(i-1) == t.charAt(j-1)){
					curr[j] = 1 + prev[j-1];
				}
				else{
					curr[j] = Math.max(prev[j], curr[j-1]);
				}
			}
			// prev = curr;
			System.arraycopy(curr, 0, prev, 0, m + 1);
		}
		return prev[m];
    }
}
 */