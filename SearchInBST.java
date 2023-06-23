import java.util.* ;
import java.io.*; 

public class SearchInBST {
    class BinaryTreeNode {
        public int data;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
    
        BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
	public static Boolean searchInBST(BinaryTreeNode root, int x) {
		// Write your code here.
		BinaryTreeNode temp = root;
		while(temp != null){
			if(temp.data == x) return true;
			
			if(temp.data < x) temp = temp.right;
			else temp = temp.left;
		}
		return false;
	}
}