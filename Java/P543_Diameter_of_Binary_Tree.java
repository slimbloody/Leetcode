public class P543_Diameter_of_Binary_Tree {
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
  
  public int diameterOfBinaryTree(TreeNode root) {
    return sol1(root);
  }
  
  int resSol1;
  public int sol1(TreeNode root) {
    resSol1 = 1;
    sol1GetHeight(root);
    return resSol1 - 1;
  }
  
  public int sol1GetHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = sol1GetHeight(root.left);
    int right = sol1GetHeight(root.right);
    resSol1 = Math.max(resSol1, left + right + 1);
    return Math.max(left, right) + 1;
  }
}
