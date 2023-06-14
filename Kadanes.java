public class Kadanes {
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
		long max = 0;
		long sum = 0;

		for(int i = 0 ; i < n; i++){
			sum += arr[i];

			if(sum > max) max = sum;
			
			if(sum < 0) sum = 0;
		}

		return (max < 0) ? 0 : max;
	}

}
