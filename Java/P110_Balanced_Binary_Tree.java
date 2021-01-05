public class P110_Balanced_Binary_Tree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode  right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  
  
  public boolean isBalanced(TreeNode root) {
    return sol1(root);
  }
  
  public boolean sol1(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    return sol1GetHeight(root) != -1;
  }
  
  private int sol1GetHeight(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = sol1GetHeight(node.left);
    int right = sol1GetHeight(node.right);
    
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
      return -1;
    }
    return Math.max(left, right) + 1;
  }
}
