import java.util.LinkedList;
import java.util.Queue;

public class P226_Invert_Binary_Tree {
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
  
  public TreeNode invertTree(TreeNode root) {
    return sol1(root);
  }
  
  public TreeNode sol1(TreeNode root) {
    if (root != null) {
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
      
      if (root.left != null) {
        sol1(root.left);
      }
      if (root.right != null) {
        sol1(root.right);
      }
    }
    
    return root;
  }
  
  // Iterative
  // level order traversal
  public TreeNode sol2(TreeNode root) {
    if (root == null) return null;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      TreeNode temp = current.left;
      current.left = current.right;
      current.right = temp;
      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
    }
    return root;
  }
}
