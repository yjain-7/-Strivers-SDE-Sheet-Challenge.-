import java.util.* ;
import java.io.*; 
public class PowerSet {
	public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
		// WRITE YOUR CODE HERE
		int n = arr.size();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		for(int num = 0 ; num < (1 << n); num++){
		
			ArrayList<Integer> temp = new ArrayList<>();
            
			for(int i = 0 ; i < n; i++){
                
				if((num & (1 << i)) != 0){
					temp.add(arr.get(i));
				}
			}

			ans.add(new ArrayList<>(temp));
		}

		return ans;
	}
}

// import java.util.* ;
// import java.io.*; 
// public class Solution {
// 	public static void helper(int ind, int size, ArrayList<Integer> arr, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ans){
// 		if(ind == size){
// 			ans.add(new ArrayList<>(ds));
// 			return;
// 		}

// 		//take
// 		ds.add(arr.get(ind));
// 		helper(ind+1, size, arr, ds, ans);
// 		//notake
// 		ds.remove(ds.size()-1);
// 		helper(ind+1, size, arr, ds, ans);

// 	}
// 	public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
// 		// WRITE YOUR CODE HERE
// 		int n = arr.size();
// 		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
// 		helper(0, n, arr, new ArrayList<>(), ans);
// 		return ans;
// 	}
// }

