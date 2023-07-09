import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure:

    
    ************************************************************/
    
public class TopView {
    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
	static class Pair{
        
		BinaryTreeNode node;
		int level;
		Pair(BinaryTreeNode _n, int _l){
			node = _n;
			level = _l;		
		}	
	}
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
		if(root == null) return new ArrayList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));
		
		while(!queue.isEmpty()){
			BinaryTreeNode node = queue.peek().node;
			int level = queue.peek().level;
			queue.remove();
			
			if(!map.containsKey(level)){
				map.put(level, node.val);
			}
			if(node.left != null){
				queue.add(new Pair(node.left, level-1));
			}
			if(node.right != null){
				queue.add(new Pair(node.right, level+1));
			}	
		}
	
		return new ArrayList<>(map.values());
		
	}
}