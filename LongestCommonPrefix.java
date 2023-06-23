import java.util.*;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] arr, int n) {
        // Write your code here
        Arrays.sort(arr);
        String str1 = arr[0];
        String str2 = arr[n - 1];

        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                break;
            }
        }

        return str1.substring(0, i);
    }

}
