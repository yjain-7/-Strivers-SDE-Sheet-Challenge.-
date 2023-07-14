import java.util.*;

public class CombinationSumII {
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        Collections.sort(arr);

        helper(0, arr, n, target, answer, new ArrayList<>());
        return answer;
    }

    public static void helper(int ind, ArrayList<Integer> arr, int n, int target, ArrayList<ArrayList<Integer>> ans,
            ArrayList<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (ind == n || target < 0)
            return;

        ds.add(arr.get(ind)); // Include the current element
        helper(ind + 1, arr, n, target - arr.get(ind), ans, ds);
        ds.remove(ds.size() - 1); // Backtrack and remove the element

        // Skip duplicates to avoid duplicate combinations
        while (ind + 1 < n && arr.get(ind) == arr.get(ind + 1)) {
            ind++;
        }

        helper(ind + 1, arr, n, target, ans, ds); // Skip the current element
    }

}