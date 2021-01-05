public class P671_Second_Minimum_Node_In_a_Binary_Tree {
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

  public int findSecondMinimumValue(TreeNode root) {
    return sol1(root);
  }
  
  public int sol1(TreeNode root) {
    if (root == null || (root.left == null) && (root.right == null)) {
      return -1;
    }
  
    TreeNode prev = null;
    TreeNode cur = root;
    
    while (cur.left != null) {
      prev = cur;
      cur = cur.left;
    }
    
    if (cur.right != null) {
      prev = cur;
      cur = cur.right;
      
      while (cur.left != null) {
        cur = cur.left;
      }
      
      return cur.val == prev.val ? -1 : cur.val;
    }
    else {
      return cur.val;
    }
  }
}
