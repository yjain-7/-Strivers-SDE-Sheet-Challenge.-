import java.util.*;
import java.io.*;
import java.util.Stack;
public class NGE {

    public static int[] nextGreater(int[] arr, int n) {
        // Write Your code here
        int[] ans = new int[n];
        ans[n - 1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = -1;
                stack.push(arr[i]);
            } else {
                ans[i] = stack.peek();
                stack.push(arr[i]);
            }
        }

        return ans;
    }

}
