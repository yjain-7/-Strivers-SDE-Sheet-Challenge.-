import java.io.*;
import java.util.* ;

public class FindMajority {
	public static int findMajority(int[] arr, int n) {
		// Write your code here.
		Arrays.sort(arr);
		int count = 1;
		for(int i = 1 ; i < n; i++){
			if(arr[i] == arr[i-1]){
				count++;
			}
			else{
				if(count > Math.floor(n/2)){
					return arr[i-1];
				}
				count = 1;
			}
		}

		if(count > Math.floor(n/2)) return arr[n-1];

		return -1;
	}
}