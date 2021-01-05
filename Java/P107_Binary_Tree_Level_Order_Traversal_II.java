import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P107_Binary_Tree_Level_Order_Traversal_II {
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
  
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    return sol1(root);
  }
  
  public List<List<Integer>> sol1(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> col = new ArrayList<>();
  
      for (int i = 0; i < size; ++i) {
        TreeNode temp = queue.poll();
        col.add(temp.val);
        
        if (temp.left != null) {
          queue.offer(temp.left);
        }
        if (temp.right != null) {
          queue.offer(temp.right);
        }
      }
      res.add(col);
    }
    
    Collections.reverse(res);
    return res;
  }
}
