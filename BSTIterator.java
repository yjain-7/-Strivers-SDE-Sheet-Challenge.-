import java.util.* ;
import java.io.*; 
/*
    Definition of Node class for reference

    class TreeNode<T> 
    {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

*/
public class Solution {

    static class BSTIterator{
        private Stack<TreeNode<Integer>> stack = new Stack<>();
        BSTIterator(TreeNode<Integer> root){
            // Write your code here
            pushAll(root);
        }

        int next(){
            // Write your code here
            TreeNode<Integer> node = stack.pop();
            pushAll(node.right);
            return node.data;
        }

        boolean hasNext(){
            // Write your code here
            return !stack.isEmpty();
        }
        private void pushAll(TreeNode<Integer> node){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
    }
}

/*
    Your BSTIterator object will be instantiated and called as such:
    BSTIterator iterator = new BSTIterator(root);
    while(iterator.hasNext())
    {
       print(iterator.next()+" ");
    }
*/
