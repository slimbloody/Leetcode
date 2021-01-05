import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P515_Find_Largest_Value_in_Each_Tree_Row {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  
  public List<Integer> largestValues(TreeNode root) {
    return sol1(root);
  }
  
  public List<Integer> sol1(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> res = new ArrayList<>();
    
    if (root == null) {
      return res;
    }
    queue.offer(root);
    
    while (!queue.isEmpty()) {
      int size = queue.size();
      int max = Integer.MIN_VALUE;
      
      for (int i = 0; i < size; ++i) {
        TreeNode temp = queue.poll();
        max = Math.max(temp.val, max);
        
        if (temp.left != null) {
          queue.offer(temp.left);
        }
        if (temp.right != null) {
          queue.offer(temp.right);
        }
      }
      res.add(max);
    }
    
    return res;
  }
  
}
