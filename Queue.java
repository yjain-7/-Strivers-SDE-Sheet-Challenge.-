import java.util.* ;
import java.io.*; 
public class Queue {
    ArrayList<Integer> arr;
    Queue() {
        // Implement the Constructor
        arr = new ArrayList<>();
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        return arr.size() == 0;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        arr.add(data);
    }

    int dequeue() {
        // Implement the dequeue() function
        if(isEmpty()) return -1;
        return arr.remove(0);
    }

    int front() {
        // Implement the front() function
        if(isEmpty()) return -1;
        return arr.get(0);

    }

}
