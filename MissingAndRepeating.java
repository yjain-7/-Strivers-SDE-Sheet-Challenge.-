import java.util.*;
import java.util.ArrayList;

public class MissingAndRepeating {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        HashSet<Integer> set = new HashSet<>();
        int repeated_element = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(arr.get(i))) {
                repeated_element = arr.get(i);
            } else {
                set.add(arr.get(i));
            }
            sum += arr.get(i);
        }

        sum -= repeated_element;
        int total_sum = (int) (n * (n + 1)) / 2;
        int missing_number = total_sum - sum;
        return new int[] { missing_number, repeated_element };

    }
}