class P687_Longest_Univalue_Path {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  
  public int longestUnivaluePath(TreeNode root) {
    return sol1(root);
  }
  
  public int sol1(TreeNode root) {
    return 1;
  }
}
