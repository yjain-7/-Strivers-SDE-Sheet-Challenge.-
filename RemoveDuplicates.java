import java.util.*;
public class RemoveDuplicates {
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		// Write your code here.
		int i = 0;
		for(int j = 0;j < n; j++){
			if(!arr.get(i).equals(arr.get(j))) i++;
			arr.set(i, arr.get(j));
		}
		return i+1;
	}
}