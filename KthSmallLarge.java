import java.util.ArrayList;
import java.util.*;

public class KthSmallLarge {
	public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		//Write your code here
		Collections.sort(arr);
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(arr.get(k-1));
		ans.add(arr.get(n-k));
		return ans;
	}
}
