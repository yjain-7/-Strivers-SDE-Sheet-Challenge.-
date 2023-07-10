import java.util.* ;
import java.io.*; 
import java.util.Queue;
public class LevelOrder {
    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
    
        public BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

  public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
    //Your code goes here
		ArrayList<Integer> answer = new ArrayList<>();
		if(root == null) return answer;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryTreeNode node = queue.poll();
			answer.add(node.val);
			if(node.left != null) queue.add(node.left);
			if(node.right != null) queue.add(node.right);
		}

		return answer;
  }

}