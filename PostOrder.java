import java.util.* ;
import java.io.*; 

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

public class PostOrder {
    public static List < Integer > getPostOrderTraversal(TreeNode root) {
    	// Write your code here.
        List<Integer> ans = new ArrayList<>();
        helper(ans, root);
        return ans;
    }
    public static void helper(List<Integer> ans, TreeNode root){
		if(root == null) return;
		helper(ans, root.left);
		helper(ans, root.right);
		ans.add(root.data);

	}
}