public class P1028_Recover_a_Tree_From_Preorder_Traversal {
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
  
  public TreeNode recoverFromPreorder(String S) {
    return sol1(S);
  }
  
  public TreeNode sol1(String S) {
    return new TreeNode();
  }
}
