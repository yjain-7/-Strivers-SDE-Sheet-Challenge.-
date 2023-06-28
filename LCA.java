import java.util.* ;
import java.io.*; 


public class LCA 
{
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
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) 
    {
        //    Write your code here.
        TreeNode<Integer> node = helper(root, x, y);
        return node.data;
    }
    public static TreeNode<Integer> helper (TreeNode<Integer> root, int x, int y){
        if(root == null || root.data == x ||root.data == y) return root;

        TreeNode<Integer> left =  helper(root.left, x, y);
        TreeNode<Integer> right = helper(root.right, x, y);

        if(left != null && right != null) return root;

        if(left != null) return left;
        return right;
    }
}
