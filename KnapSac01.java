import java.util.* ;
import java.io.*; 
//Tabulation
public class KnapSac01{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            int[][] dp = new int[n][maxWeight+1];
            for(int w = weight[0]; w <= maxWeight; w++){
                dp[0][w] = value[0];
            }
            for(int ind = 1; ind < n; ind++){
                for(int wt = 0; wt <= maxWeight; wt++){
                    int notTake = dp[ind-1][wt];
                    int take = -1;
                    if(weight[ind] <= wt){
                        
                        take = value[ind] + dp[ind-1][wt-weight[ind]];
                    }
            
                    dp[ind][wt] = Math.max(notTake, take);
                }
            }
            
            return dp[n-1][maxWeight];

    }
}

/*
 import java.util.* ;
import java.io.*; 
//Memoization
public class Solution{
    public static int f(int ind, int wt, int size, int[] weight, int[] value, int[][] dp){
        if(ind == 0){
            if(weight[0] <= wt){
                return value[0];
            }
            return 0;
        }
        if(dp[ind][wt] != -1) return dp[ind][wt];
        
        int notTake = f(ind-1, wt, size, weight, value, dp);
        int take = -1;
        if(weight[ind] <= wt){
            
            take = value[ind] + f(ind-1, wt-weight[ind], size, weight, value, dp);
        }

        return dp[ind][wt] = Math.max(notTake, take);
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            int[][] dp = new int[n][maxWeight+1];
            for(int[] row : dp){
                Arrays.fill(row, -1);
            }
            return f(n-1, maxWeight, n, weight, value, dp);

    }
}

import java.util.* ;
import java.io.*; 

public class Solution{
    public static int f(int ind, int wt, int size, int[] weight, int[] value, int[][] dp){
        if(ind == 0){
            if(weight[0] <= wt){
                return value[0];
            }
            return 0;
        }

        int notTake = f(ind-1, wt, size, weight, value);
        int take = -1;
        if(weight[ind] <= wt){
            
            take = value[ind] + f(ind-1, wt-weight[ind], size, weight, value);
        }

        return Math.max(notTake, take);
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            return f(n-1, maxWeight, n, weight, value);

    }
}*/
