/*************************************************************

Following is the Binary Tree Node structure:


*************************************************************/

public class MaxDiameterbetweenAnyTwoNodes {
    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;
    
        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
          }
    }
	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		// Write your code here.

		int[] max = new int[1];
		int x = diameter(root, max);
		return max[0];
	}

	public static int diameter(TreeNode<Integer> node, int[] max){
		if(node == null) return 0;

		int lh = diameter(node.left, max);
		int rh = diameter(node.right, max);

		max[0] = Math.max(max[0], lh+rh);

		return 1 + Math.max(lh, rh);
	}
}