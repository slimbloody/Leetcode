public class P104_Maximum_Depth_of_Binary_Tree {
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
  
  public int maxDepth(TreeNode root) {
    return sol1(root);
  }
  
  public int sol1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    else {
      int left = sol1(root.left);
      int right = sol1(root.right);
      return 1 + Math.max(left, right);
    }
  }
}
