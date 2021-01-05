import java.util.LinkedList;
import java.util.Queue;

public class P101_Symmetric_Tree {
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
  
  public boolean isSymmetric(TreeNode root) {
    return sol1(root);
  }
  
  // recursive
  public boolean sol1(TreeNode root) {
    return sol1(root, root);
  }
  
  public boolean sol1(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return true;
    }
    if (t1 == null || t2 == null) {
      return false;
    }
    
    return (t1.val == t2.val)
        && sol1(t1.right, t2.left)
        && sol1(t1.left, t2.right);
  }
  
  // iterative
  public boolean sol2(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(root);
    
    while (!queue.isEmpty()) {
      TreeNode t1 = queue.poll();
      TreeNode t2 = queue.poll();
      
      if (t1 == null && t2 == null) {
        continue;
      }
      if (t1 == null || t2 == null) {
        return false;
      }
      if (t1.val != t2.val) {
        return false;
      }
  
      queue.add(t1.left);
      queue.add(t2.right);
      queue.add(t1.right);
      queue.add(t2.left);
    }
    
    return true;
  }
  
  // level order traversal
  public boolean sol3(TreeNode root) {
    return true;
  }
}
