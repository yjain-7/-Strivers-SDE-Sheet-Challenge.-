import java.util.*;
import java.io.*;
/*   
    Following is the Binary Tree node structure for referance:

    */

public class PathInTree {
    class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int item) {
            data = item;
            left = right = null;
        }
    }

    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        ArrayList<Integer> answer = new ArrayList<>();
        if (helper(root, answer, x)) {
            return answer;
        }
        return new ArrayList<>();
    }

    public static boolean helper(TreeNode node, ArrayList<Integer> answer, int x) {
        if (node == null)
            return false;

        answer.add(node.data);

        if (node.data == x) {
            return true;
        }

        if (helper(node.left, answer, x)) {
            return true;
        }

        if (helper(node.right, answer, x)) {
            return true;
        }

        answer.remove(answer.size() - 1);

        return false;

    }
}