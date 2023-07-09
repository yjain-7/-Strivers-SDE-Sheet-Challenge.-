import java.util.* ;
import java.io.*; 
public class SubsetII {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        // Write your code here..
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        Arrays.sort(arr);
        helper(arr, n, 0, answer, new ArrayList<>());
        return answer;
    }

    public static void helper(int[] arr, int size, int index, ArrayList<ArrayList<Integer>> answer, ArrayList<Integer> ds){
        
        answer.add(new ArrayList<>(ds));

        for(int i = index; i < size; i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            ds.add(arr[i]);
            helper(arr, size, i+1, answer, ds);
            ds.remove(ds.size()-1);        
            // helper(arr, size, i+1, answer, ds);
        }
    }

}