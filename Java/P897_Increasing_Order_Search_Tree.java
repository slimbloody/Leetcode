public class P897_Increasing_Order_Search_Tree {
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
  
  public TreeNode increasingBST(TreeNode root) {
    return sol1(root);
  }
  
  // best solution relink
  public TreeNode sol1(TreeNode root) {
    return sol1(root, null);
  }
  
  public TreeNode sol1(TreeNode root, TreeNode next) {
    if (root == null) {
      return next;
    }
    
    TreeNode res = sol1(root.left, root);
    root.left = null;
    root.right = sol1(root.right, next);
    return res;
  }
  
  // inorder traversal
  public TreeNode sol2(TreeNode root) {
    return sol2(root, null);
  }
  
  public TreeNode sol2(TreeNode root, TreeNode next) {
    if (root == null) {
      return next;
    }
    TreeNode res = sol2(root.left, root);
    root.left = null;
    root.right = sol2(root.right, next);
    return res;
  }
}
