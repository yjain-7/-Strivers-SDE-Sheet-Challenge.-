import java.io.*;
import java.util.* ;
import java.util.ArrayList;
public class MMorityElement-II {
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        // Write your code here.
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < arr.size(); i++){
              freqMap.put(arr.get(i), freqMap.getOrDefault(arr.get(i), 0) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            if(entry.getValue() > Math.floor(arr.size()/3)){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}