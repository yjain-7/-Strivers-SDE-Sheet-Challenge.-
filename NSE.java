import java.util.*;
import java.io.*;
import java.util.Stack;
public class NSE{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        // int n = arr.size();
        ArrayList<Integer> ans = new ArrayList<>(n);
		ans.add(-1);
		Stack<Integer> stack = new Stack<>();
		stack.push(arr.get(n-1));

		for(int i = n-2; i >= 0; i--){
			while(!stack.isEmpty() && stack.peek() >= arr.get(i)){
				stack.pop();
			}

			if(stack.isEmpty()) {
				ans.add(-1);
			}
			else{
				ans.add(stack.peek());
			}
            stack.push(arr.get(i));
		}
        Collections.reverse(ans);
		return ans;
    }
}
