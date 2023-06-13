import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class FindDuplicate{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        // Write your code here.
        int slow = 0;
        int fast = 0;
        do{
            slow = arr.get(slow);
            fast = arr.get(arr.get(fast));
        }while(fast != slow);

        slow = 0;
        while(slow != fast){
            slow = arr.get(slow);
            fast = arr.get(fast);
        }

        return slow;
    }
}
