import java.util.* ;
import java.io.*; 
public class MinCoin{
    public static int findMinimumCoins(int amount){
        // Write your code here.
        int[] currency = {1000,500,100,50,20,10,5,2,1};
        int n = currency.length;
        int count = 0;
        int i = 0;
        while(i < n){
            if(amount == 0) break;
            if(currency[i] <= amount){
                count++;
                amount = amount - currency[i]; 
            }else{
                i++;
            }
        }

        return count;
        
    }
    public static void main(String[] args) {
        System.out.println(findMinimumCoins(50));
    }
}
