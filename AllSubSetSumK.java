import java.util.*;

public class AllSubSetSumK {
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        helper(0, n, arr, k, ans, new ArrayList<>());
        return ans;
    }
    
    public static void helper(int ind, int size, ArrayList<Integer> arr, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds) {
        if (ind == size){
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return; 
        }
        
        ds.add(arr.get(ind));
        helper(ind + 1, size, arr, target - arr.get(ind), ans, ds);
        ds.remove(ds.size() - 1);
        helper(ind + 1, size, arr, target, ans, ds);
    }
}
