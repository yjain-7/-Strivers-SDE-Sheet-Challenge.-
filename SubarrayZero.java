import java.io.*;
import java.util.*;

import java.util.ArrayList;

public class SubarrayZero {

    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();
        // Write your code here.
        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < arr.size(); i++) {

            sum += arr.get(i);

            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (mpp.get(sum) != null) {

                    maxi = Math.max(maxi, i - mpp.get(sum));
                } else {

                    mpp.put(sum, i);
                }
            }
        }
        return maxi;

    }
}