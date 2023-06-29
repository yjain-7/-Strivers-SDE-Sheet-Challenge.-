import java.util.* ;
import java.io.*; 

public class ZigZagTraversal {
    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    
        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
		// Write your code here!
		List<Integer> answer = new ArrayList<>();
		if(root == null) return answer;
		
		boolean direction = true; 
		
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(!queue.isEmpty()){
			int n = queue.size();
		
			ArrayList<Integer> subList = new ArrayList<>(n);
		
			for(int i = 0 ; i < n; i++){
				
				BinaryTreeNode<Integer> node = queue.poll();
				subList.add(node.data);
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			direction = !direction;
			if(direction) Collections.reverse(subList);
			for(int i : subList){
				answer.add(i);
			}
		}
		return answer;
	}
}
