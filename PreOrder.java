import java.util.* ;
import java.io.*; 
/*
	
	Following is the Binary Tree node structure:

	public class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.data = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	       this.data = val;
	        this.left = left;
	        this.right = right;
	    }
	}

*/

public class PreOrder {
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	// Write your code here.
		//root, left, right
		List<Integer> ans = new ArrayList<>();
		helper(ans, root);
		return ans;
    }
	public static void helper(List<Integer> ans, TreeNode root){
		if(root == null) return;
		ans.add(root.data);
		helper(ans, root.left);
		helper(ans, root.right);
	}
}