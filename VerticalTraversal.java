import java.util.* ;
import java.io.*;     
public class VerticalTraversal {
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
    };
    static class Pair{
        TreeNode<Integer> node;
        int level;
        Pair(TreeNode<Integer> _node, int _level){
            node = _node;
            level = _level;
        }
    }
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        //    Write your code here.
        if(root == null) return new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()){
            TreeNode<Integer> node = queue.peek().node;
            int level = queue.peek().level;
            queue.remove();

            if(!map.containsKey(level)){
                map.put(level, new ArrayList<>());
            }
            if(map.containsKey(level)){
                ArrayList<Integer> temp = map.get(level);
                temp.add(node.data);
                map.put(level, temp);
            }

            if(node.left != null) queue.add(new Pair(node.left, level-1));
            if(node.right != null) queue.add(new Pair(node.right, level+1));
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(ArrayList<Integer> arr : map.values()){
            for(int i : arr){
                ans.add(i);
            }
        }

        return ans;
    }
}