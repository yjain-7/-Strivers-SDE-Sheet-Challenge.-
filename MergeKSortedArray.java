import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class MergeKSortedArray{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(ArrayList<Integer> arr : kArrays){
			for(int i : arr){
				queue.add(i);
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		while(!queue.isEmpty()){
			ans.add(queue.poll());
		}
		return ans;
	}
}
