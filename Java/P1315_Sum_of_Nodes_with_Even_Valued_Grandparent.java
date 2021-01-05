public class P1315_Sum_of_Nodes_with_Even_Valued_Grandparent {
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
  
  public int sumEvenGrandparent(TreeNode root) {
    return sol1(root);
  }
  
  public int sol1(TreeNode root) {
    return 1;
  }
}
