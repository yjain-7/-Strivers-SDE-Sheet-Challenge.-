import java.util.*;
import java.io.*;
import java.util.Queue;
public class MaxWidth {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static int getMaxWidth(TreeNode root) {
        // Write your code here.
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int max = 0;

        while (!queue.isEmpty()) {
            int currWidth = queue.size();
            max = Math.max(max, currWidth);

            while (currWidth > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                currWidth--;
            }
        }

        return max;
    }
}