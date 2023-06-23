import java.util.*;
import java.io.*;

public class findCeilInBST{
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int findCeil(TreeNode node, int x) {
        int result = -1;
        // Write your code here
        TreeNode temp = node;
        while (temp != null) {
            if (temp.data >= x)
                result = temp.data;
            if (temp.data < x)
                temp = temp.right;
            else
                temp = temp.left;
        }

        return result;

    }
}
