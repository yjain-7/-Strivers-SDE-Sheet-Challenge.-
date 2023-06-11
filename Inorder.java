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

public class Inorder {
    public static List < Integer > getInOrderTraversal(TreeNode root) {
    	// Write your code here.
        // left root right
        List<Integer> ans = new ArrayList<>();
        helper(ans, root);
        return ans;
    }
    public static void helper(List<Integer> ans, TreeNode root){
        if(root == null) return;
        helper(ans, root.left);
        ans.add(root.data);
        helper(ans, root.right);
    }
}