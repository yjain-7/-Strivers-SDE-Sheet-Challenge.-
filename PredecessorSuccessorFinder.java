import java.util.ArrayList;

public class PredecessorSuccessorFinder {
    public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, key, ans);
        return ans;
    }

    public static void helper(BinaryTreeNode<Integer> node, int key, ArrayList<Integer> ans) {
        if (node == null) {
            return;
        }
        if (node.data == key) {
            if (node.left == null)
                ans.add(-1);
            else
                ans.add(node.left.data);

            if (node.right == null)
                ans.add(-1);
            else
                ans.add(node.right.data);
        }
        if (node.data > key)
            helper(node.left, key, ans);
        else
            helper(node.right, key, ans);
    }
}
