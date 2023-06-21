public class ReverseLL {
    class LinkedListNode<T> 
    {
        T data;
        LinkedListNode<T> next;
        public LinkedListNode(T data) 
        {
            this.data = data;
        }
    }
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        // Write your code here!
		if(head == null || head.next == null) return head;
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> curr = head;
		LinkedListNode<Integer> next = null;

		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
		
    }
}