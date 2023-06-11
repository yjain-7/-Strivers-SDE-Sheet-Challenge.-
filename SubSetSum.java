import java.util.* ;
import java.io.*; 
public class SubSetSum {
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
        ArrayList<Integer> ans = new ArrayList<>();
        helper(0, 0,ans, num);
        Collections.sort(ans);
        return ans;
    }
    public static void helper(int i, int sum, ArrayList<Integer> ans, int[] num){
        if(i == num.length){
            ans.add(sum);
            return;
        }

        //take it
        sum+= num[i];
        helper(i+1, sum, ans, num);
        sum -= num[i];
        helper(i+1, sum, ans, num);

    }

}