import java.util.* ;
import java.io.*; 
/*

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

*/

public class LCAInBST 
{

	public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) 
    {		
        // Write your code here
        if(root == null || root.equals(p) ||root.equals(q)) return root;

        TreeNode<Integer> left = null;
        TreeNode<Integer> right = null;

        if(root.data > p.data && root.data > q.data){
            left = LCAinaBST(root.left, p, q);
        }else if(root.data < p.data && root.data < q.data){
            right = LCAinaBST(root.right, p, q);
        }else{
            left = LCAinaBST(root.left, p, q);
            right = LCAinaBST(root.right, p, q);

        }

        if(left != null && right != null) return root;

        if(left != null) return left;
        return right;
	}
}