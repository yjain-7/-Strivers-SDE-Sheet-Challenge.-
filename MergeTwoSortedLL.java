// https://www.codingninjas.com/codestudio/problems/merge-two-sorted-linked-lists_8230729?challengeSlug=striver-sde-challenge&leftPanelTab=1
import java.io.*;
import java.util.* ;
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }



public class MergeTwoSortedLL {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		// Write your code here.
        LinkedListNode<Integer> head = new LinkedListNode<>(-1);
        LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> ftemp = first;
        LinkedListNode<Integer> stemp = second;

        while(ftemp != null && stemp != null){
            if(ftemp.data <= stemp.data){
                temp.next = ftemp;
                ftemp = ftemp.next;
            }else{
                temp.next = stemp;
                stemp = stemp.next;
            }
            temp = temp.next;
        }

        if(ftemp != null){
            temp.next = ftemp;
        }
        if(stemp != null){
            temp.next = stemp;
        }

        return head.next;
	}
}
