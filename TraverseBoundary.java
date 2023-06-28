import java.util.*;
import java.io.*;

import java.util.ArrayList;

public class TraverseBoundary {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static ArrayList<Integer> traverseBoundary(TreeNode root) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        ans.add(root.data);

        getLeftNodes(root.left, ans);
        getLeafNodes(root.left, ans);
        getLeafNodes(root.right, ans);
        getRightNodes(root.right, ans);

        return ans;
    }

    public static void getLeftNodes(TreeNode node, ArrayList<Integer> ans) {
        while (node != null) {
            if (node == null || (node.left == null && node.right == null))
                break;
            ans.add(node.data);
            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    public static void getLeafNodes(TreeNode node, ArrayList<Integer> ans) {
        if (node == null)
            return;
        getLeafNodes(node.left, ans);
        if (node.left == null && node.right == null) {
            ans.add(node.data);
            return;
        }
        getLeafNodes(node.right, ans);

    }

    public static void getRightNodes(TreeNode node, ArrayList<Integer> ans) {
        ArrayList<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (node == null || (node.left == null && node.right == null))
                break;
            temp.add(node.data);
            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }
        Collections.reverse(temp);
        ans.addAll(temp);

    }
}