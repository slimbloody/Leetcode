public class P662_Maximum_Width_of_Binary_Tree {
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
  
  public int widthOfBinaryTree(TreeNode root) {
    return sol1(root);
  }
  
  public int sol1(TreeNode root) {
    return 1;
  }
}
