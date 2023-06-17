import java.util.* ;
import java.io.*; 
public class Permutation {
    public static List<String> findPermutations(String s) {
        // Write your code here.
        List<String> ans = new ArrayList<>();
        helper(ans, s.toCharArray(), 0);
        return ans;
    }

    public static void helper(List<String> ans, char[] s, int index){
        if(index == s.length){
            String temp = new String(s);
            ans.add(temp);
            return;
        }
        for(int i = index; i < s.length; i++){
            swap(s, index, i);
            helper(ans, s, index+1);
            swap(s, index, i);
        }
    }
    public static void swap(char[] s, int x, int y){
        char temp = s[x];
        s[x] = s[y];
        s[y] = temp;
    }
}