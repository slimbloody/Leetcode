import java.util.LinkedList;
import java.util.Queue;

public class P1302_Deepest_Leaves_Sum {
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
  
  public int deepestLeavesSum(TreeNode root) {
    return sol1(root);
  }
  
  public int sol1(TreeNode root) {
    int res = 0;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (queue.size() != 0) {
      res = 0;
      int tempLevelLen = queue.size();
      
      for (int i = 0; i < tempLevelLen; ++i) {
        TreeNode temp = queue.poll();
  
        res += temp.val;
  
        if (temp.left != null) {
          queue.offer(temp.left);
        }
        if (temp.right != null) {
          queue.offer(temp.right);
        }
      }
    }
    
    return res;
  }
}
