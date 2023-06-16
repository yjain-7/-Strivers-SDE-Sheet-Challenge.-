

public class SymmetricTree{
    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    
        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        // Write your code here.
        if(root == null) return true;
        
        return helper(root.right, root.left);
    }
    public static boolean helper(BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q){
        if(p == null || q == null) return (p == q);
        
        return ((p.data.equals(q.data)) && (helper(p.right, q.left)) && (helper(p.left, q.right)));
    }
}