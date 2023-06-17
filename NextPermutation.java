import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation 
{
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
		// Write your code here.
		int n = permutation.size();
		int ind = -1;
		for(int i = n-2; i >= 0; i--){
			if(permutation.get(i) < permutation.get(i+1)){
				ind = i;
				break;
			}
		}
		if(ind == -1){
			Collections.reverse(permutation);
			return permutation;
		}
		int x = permutation.get(ind);
		for(int i = n-1; i > ind; i--){
			if(permutation.get(i) > x){
				int y = permutation.get(i);
				permutation.set(ind, y);
				permutation.set(i, x);
				break;
			}
		}

		Collections.reverse(permutation.subList(ind+1, n));
		return permutation;
	}
}
