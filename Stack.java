import java.util.ArrayList;

public class Stack {
    // Declare array.
    ArrayList<Integer> myStack;

    // Stack size.
    int stackSize;

    // Maximum size.
    int n;

    // Constructor function.
    Stack(int n) {

        // Initialize class objects.
        myStack = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            myStack.add(0);
        }
        stackSize = -1;
        this.n = n;
    }

    // Push function.
    void push(int num) {

        // Check if stack is not full.
        if (stackSize != n - 1) {

            // Increment stack size and update array.
            ++stackSize;
            myStack.set(stackSize, num);
        }
    }

    // Pop function.
    int pop() {

        // Check if stack is not empty.
        if (stackSize != -1) {

            // Decrease size and return element.
            --stackSize;
            return myStack.get(stackSize + 1);
        } else {
            return -1;
        }
    }

    // Top function.
    int top() {

        // Check if stack is not empty.
        if (stackSize != -1) {

            // Return element.
            return myStack.get(stackSize);
        } else {
            return -1;
        }
    }

    // To check whether stack is empty or not.
    int isEmpty() {

        // Check if stack is not empty.
        if (stackSize != -1) {

            // Return element.
            return 0;
        } else {
            return 1;
        }
    }

    // To check whether stack is full or not.
    int isFull() {

        // Check if stack is not empty.
        if (stackSize != n - 1) {

            // Return element.
            return 0;
        } else {
            return 1;
        }
    }
}
