import java.util.* ;
import java.io.*; 
public class DistinctSubstring {
    public static int distinctSubstring(String word) {
        // Write your code here.
        int n = word.length();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j <= n; j++){
                String str = word.substring(i, j);
                set.add(str);
            }
        }

        return set.size();
    }
}
