import java.util.*;
import java.io.*;


public class PalindromLL {
    static LinkedListNode reverseList(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode post = null;
        while (curr != null) {
            post = curr.next;
            curr.next = prev;
            prev = curr;
            curr = post;

        }
        return prev;
    }

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        // Write your code here!
        if (head == null || head.next == null)
            return true;
        LinkedListNode slow = head;
        LinkedListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedListNode head2 = slow.next;
        slow.next = null;
        head2 = reverseList(head2);
        while (head != null && head2 != null) {
            if ((int) head.data != (int) head2.data)
                return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
}