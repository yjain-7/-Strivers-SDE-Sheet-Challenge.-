import java.util.*;
import java.io.*;
/************************************************************

    Following is the TreeNode class structure

    
    ************************************************************/

import java.util.ArrayList;

public class LeftView
{
class TreeNode<T> 
    {
       public T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };


    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> answer = new ArrayList<>();
        helper(root, 0, answer);
        return answer;
    }

    public static void helper(TreeNode<Integer> node, int level, ArrayList<Integer> answer) {
        if (node == null)
            return;

        if (level == answer.size())
            answer.add(node.data);

        helper(node.left, level + 1, answer);
        helper(node.right, level + 1, answer);
    }
}
