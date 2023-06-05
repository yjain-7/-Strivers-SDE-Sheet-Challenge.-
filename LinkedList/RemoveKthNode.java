public class RemoveKthNode {
    class Node {
        public int data;
        public Node next;
        public Node prev;

        Node() {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = next;
        }
    }

    public static Node removeKthNode(Node head, int K) {
        // Write your code here.
        if (head == null)
            return head;
        if (K == 0)
            return head;
        Node temp = head;

        while (K != 0) {
            temp = temp.next;
            K--;
        }

        if (temp == null) {
            head = head.next;
            return head;
        }

        Node temp2 = head;

        while (temp.next != null) {
            temp2 = temp2.next;
            temp = temp.next;
        }

        temp2.next = temp2.next.next;
        return head;
    }
}