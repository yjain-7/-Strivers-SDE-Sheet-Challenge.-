import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class BuyAndSellStock{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        int max = prices.get(prices.size()-1);
        int maxProfit = 0;
        for(int i = prices.size()-1; i >=0; i--){
            int curr = prices.get(i);
            max = Math.max(max, curr);
            maxProfit = Math.max(maxProfit, max-curr);
        }
        return maxProfit;
    }
}