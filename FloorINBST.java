import java.util.*;
import java.io.*;

/************************************************************
 * 
 * Following is the TreeNode class structure
 * 
 * 
 ************************************************************/

public class FloorINBST {
    class TreeNode<T>
    {
       public
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int floorInBST(TreeNode<Integer> root, int X) {
        // Write your code here.
        int floor = -1;
        while (root != null) {
            if (root.data == X)
                return root.data;
            else if (X < root.data) {
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}