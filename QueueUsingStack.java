import java.util.*;
import java.util.Stack;
public class QueueUsingStack {
    // Define the data members(if any) here.
    Stack<Integer> stack1; 
    Stack<Integer> stack2; 

    QueueUsingStack() {
        // Initialize your data structure here.
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    void enQueue(int val) {
        // Implement the enqueue() function.
        stack1.push(val);
    }

    int deQueue() {
        // Implement the dequeue() function.
        if(isEmpty()){
            return -1;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int removed = stack2.pop();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return removed;
    }

    int peek() {
        // Implement the peek() function here.
        if(isEmpty()){
            return -1;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int peek = stack2.peek();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return peek;
    }

    boolean isEmpty() {
        // Implement the isEmpty() function here.
        return stack1.isEmpty();
    }
}