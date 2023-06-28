import java.util.ArrayList;
import java.util.List;
public class Traversal {
    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    
        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
		List<Integer> inOrder = new ArrayList<>();
		List<Integer> preOrder = new ArrayList<>();
		List<Integer> postOrder = new ArrayList<>();
		
		traversal(inOrder, preOrder, postOrder, root);

		List<List<Integer>> answer = new ArrayList<>();
		answer.add(inOrder);
		answer.add(preOrder);
		answer.add(postOrder);
		return answer;
    }

	public static void traversal(List<Integer> inOrder, List<Integer> preOrder,List<Integer> postOrder, BinaryTreeNode<Integer> root){
		if(root == null) return;
		preOrder.add(root.data);
		traversal(inOrder, preOrder, postOrder, root.left);
		inOrder.add(root.data);
		traversal(inOrder, preOrder, postOrder, root.right);
		postOrder.add(root.data);
	}


}
