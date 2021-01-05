public class P993_Cousins_in_Binary_Tree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  
  public boolean isCousins(TreeNode root, int x, int y) {
    return sol1(root, x, y);
  }
  
  public class info {
    TreeNode t;
    TreeNode parent;
    TreeNode grandParenet;
    int val;
  }
  
  public boolean sol1(TreeNode root, int x, int y) {
    return true;
  }
}
