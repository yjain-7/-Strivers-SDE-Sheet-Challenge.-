import java.util.Stack;
import java.io.*; 
public class SortStack {
    // Helper function to insert an element at the right position in the sorted stack
    public static void sorting(Stack<Integer> stack, int num) {
        // If the stack is empty or the top element is less than the new element (num),
        // then insert the new element at the top of the stack and return.
        if (stack.isEmpty() || stack.peek() < num) {
            stack.push(num);
            return;
        }
        // Remove the top element from the stack
        int n = stack.pop();
        // Recursively call sorting to insert the new element at the right position
        sorting(stack, num);
        // Push the removed element back to the stack after the new element is inserted
        stack.push(n);
    }
    // Main function to sort the stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        // If the stack is empty, just return
        if (stack.isEmpty()) return;
        // Remove the top element from the stack
        int num = stack.pop();
        // Recursively call sortStack to sort the remaining elements in the stack
        sortStack(stack);
        // Insert the removed element at the right position in the sorted stack
        sorting(stack, num);
    }
}