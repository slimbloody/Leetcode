import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P103_Binary_Tree_Zigzag_Level_Order_Traversal {
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
  
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    return sol1(root);
  }
  
  public List<List<Integer>> sol1(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    
    int counter = 0;
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
      if ((counter++ & 1) == 1) {
        Collections.reverse(col);
      }
      res.add(col);
    }
    
    return res;
  }
}
