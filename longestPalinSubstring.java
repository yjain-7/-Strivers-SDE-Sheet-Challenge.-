import java.util.*;
public class longestPalinSubstring {	
	public static int longestPalinSubstring(String str) {
		// Write your code here.
		StringBuilder str2 = new StringBuilder(str);
		str2.reverse();
		// String s2 = str2.toString();
		int n = str.length();
		int max = 0;
		int[][] dp = new int[n+1][n+1];
		for(int i = 1; i <=n; i++){
			for(int j = 1; j <=n; j++){
				if(str.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		System.out.println(max);
		return max;
		// return " ";
	}
	public static void main(String[] args) {
		String str = "abccbed";
		System.out.println(longestPalinSubstring(str));
	}
}
