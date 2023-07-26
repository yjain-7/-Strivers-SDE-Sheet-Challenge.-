import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class SubArrayXOR {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Write your code here.
		int count = 0;
        int xorPrefix = 0;
        Map<Integer, Integer> xorCounts = new HashMap<>();
        xorCounts.put(0, 1); // Initial prefix XOR is 0 with count 1 (empty subarray)

        for (int i = 0; i < arr.size(); i++) {
            xorPrefix ^= arr.get(i);

            // Check if there is a subarray ending at index i with XOR equal to 'x'
            int requiredXor = xorPrefix ^ x;
            if (xorCounts.containsKey(requiredXor)) {
                count += xorCounts.get(requiredXor);
            }

            // Update the count of current xorPrefix in the map
            xorCounts.put(xorPrefix, xorCounts.getOrDefault(xorPrefix, 0) + 1);
        }

        return count;
    
	}
}