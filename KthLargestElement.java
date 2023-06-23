import java.util.* ;
import java.io.*; 
public class KthLargestElement {

	static int kthLargest(ArrayList<Integer> arr, int size, int K) {
		// Write your code here.
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0 ; i < size; i++){
			pq.add(arr.get(i));
		}

		for(int i = 0; i < K-1 ; i++){
			pq.poll();
		}

		return pq.poll();
	}
}
