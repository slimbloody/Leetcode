
public class P965_Univalued_Binary_Tree {
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
  
  public boolean isUnivalTree(TreeNode root) {
    return sol1(root);
  }
  
  public boolean sol1(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    if (root.left != null){
      if (root.val != root.left.val) {
        return false;
      }
    }
  
    if (root.right != null){
      if (root.val != root.right.val) {
        return false;
      }
    }
    
    return sol1(root.left) && sol1(root.right);
  }
  
  int val = -1;
  public boolean sol2(TreeNode root) {
    if (root == null) return true;
    if (val < 0) val = root.val;
    return root.val == val
        && isUnivalTree(root.left)
        && isUnivalTree(root.right);
  }
}
