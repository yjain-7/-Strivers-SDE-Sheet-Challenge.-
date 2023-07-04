
public class RotateLL {
    class Node {
        public int data;
        public Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    };

    public static Node rotate(Node head, int k) {
        // Write your code here.
        if (head == null || head.next == null || k == 0)
            return head;
        int size = 0;
        Node temp = head;
        Node last = temp;
        while (temp != null) {
            last = temp;
            temp = temp.next;
            size++;
        }
        k = k % size;
        k = size - k;

        if (k == 0)
            return head;

        Node temp1 = head;
        for (int i = 1; i < k; i++) {
            temp1 = temp1.next;
        }

        last.next = head;
        head = temp1.next;
        temp1.next = null;

        return head;
    }
}