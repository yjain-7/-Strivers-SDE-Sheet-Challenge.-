import java.util.*;
import java.io.*;

/*************************************************************
 * 
 * Following is the Binary Tree node structure
 * 
 *************************************************************/
public class BalancedBT {

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
        // Write your code here.
        int flag = helper(root);
        if (flag == -1)
            return false;
        return true;
    }

    public static int helper(BinaryTreeNode<Integer> node) {
        if (node == null)
            return 0;

        int lh = helper(node.left);
        int rh = helper(node.right);

        if (lh == -1 || rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;

        return 1 + Math.max(lh, rh);

    }
}
