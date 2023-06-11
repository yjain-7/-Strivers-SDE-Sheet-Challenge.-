import java.util.* ;
import java.io.*; public class SubsetSumK {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][] dp = new int[n][k+1];
        return recurse(0,0,k,arr,dp) == 1 ? true : false; 
    }
    public static int recurse(int i,int sum,int k,int[] arr,int[][] dp)
    {
        if(i==arr.length || sum==k)
        {
            if(sum==k)return 1;
            return -1;
        }
        if(dp[i][sum]!=0)return dp[i][sum];
        
        int take= 0,notake = 0;

        if(arr[i]+sum<=k)
        {
            take = recurse(i+1,sum+arr[i],k,arr,dp);
        }
        notake = recurse(i+1,sum,k,arr,dp);

        if(take==1 || notake==1){
            dp[i][sum] = 1;
        }
        else{
            dp[i][sum] = -1;
        }

        return dp[i][sum];
    }
}
