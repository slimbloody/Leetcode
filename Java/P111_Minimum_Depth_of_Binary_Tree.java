public class P111_Minimum_Depth_of_Binary_Tree {
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
  
  
  /*
  Why expected result for input of {1,2} is 2? Shouldn't it be 1?
  The root 1 has a left child 2, so it is not a leaf node.
   */
  public int minDepth(TreeNode root) {
    return sol1(root);
  }
  
  public int sol1(TreeNode root) {
    if(root == null) {
      return 0;
    }
    int left = sol1(root.left);
    int right = sol1(root.right);
    return (left == 0 || right == 0)
        ? left + right + 1: Math.min(left,right) + 1;
  }
  
  public int sol3(TreeNode root) {
    if (root == null) {
      return 0;
    }
    else {
      int left = sol3(root.left);
      int right = sol3(root.right);
      
      if (left != 0 && right == 0) {
        return 1 + left;
      }
      else if (left == 0 && right != 0) {
        return 1 + right;
      }
      else {
        return 1 + Math.min(left, right);
      }
    }
  }
}
