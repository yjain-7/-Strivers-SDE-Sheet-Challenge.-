import java.util.*;
import java.io.*;

public class IdenticalTrees {
    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        // Write you code here.
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        if (!root1.data.equals(root2.data)) {
            return false;
        }

        return identicalTrees(root1.left, root2.left) && identicalTrees(root1.right, root2.right);
    }

}