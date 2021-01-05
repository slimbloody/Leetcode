import java.util.LinkedList;
import java.util.Queue;

public class P513_Find_Bottom_Left_Tree_Value {
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
  
  public int findBottomLeftValue(TreeNode root) {
    return sol1(root);
  }
  
  public int sol1(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int res = 0;
    
    while (!queue.isEmpty()) {
      int tempSize = queue.size();
      
      for (int i = 0; i < tempSize; ++i) {
        TreeNode temp = queue.poll();
        if (i == 0) {
          res = temp.val;
        }
        
        if (temp.left != null) {
          queue.offer(temp.left);
        }
        if (temp.right != null) {
          queue.offer(temp.right);
        }
      }
    }
    
    return  res;
  }
  
  // dfs + stack
  // record the depth
  public int sol2(TreeNode root) {
    return 1;
  }
}
