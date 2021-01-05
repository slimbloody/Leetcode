public class P979_Distribute_Coins_in_Binary_Tree {
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
  
  public int distributeCoins(TreeNode root) {
    return sol1(root);
  }
  
  private int sol1Res = 0;
  public int sol1(TreeNode root) {
    sol1_1Helper(root);
    return sol1Res;
  }
  
  private int sol1_1Helper(TreeNode root) {
    if (root == null) {
      return 1;
    }
    
    int left = sol1_1Helper(root.left) - 1;
    sol1Res += Math.abs(left);
    int right = sol1_1Helper(root.right) - 1;
    sol1Res += Math.abs(right);
  
    return left + right + root.val;
  }
  
  private int sol1_2Helper(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int left = sol1_2Helper(root.left);
    sol1Res += Math.abs(left);
    int right = sol1_2Helper(root.right);
    sol1Res += Math.abs(right);
    
    return left + right + root.val - 1;
  }
}
