import java.util.* ;
import java.io.*; 

import java.util.ArrayList;
public class KthSmallestInBST{
    class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;
    
        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static int KthLargestNumber(TreeNode root, int k) {
		// Write your code here.
		ArrayList<Integer> arr = new ArrayList<>();
		inOrderTraversal(arr, root);
		int n = arr.size();
		if(k > n) return -1;
		return arr.get(k-1);
	}

	public static void inOrderTraversal(ArrayList<Integer> arr, TreeNode node){
		if(node == null) return;
		inOrderTraversal(arr, node.left);
		arr.add(node.data);
		inOrderTraversal(arr, node.right);

	}
}