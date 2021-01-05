public class P617_Merge_Two_Binary_Trees {
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
  
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    return sol1(t1, t2);
  }
  
  public TreeNode sol1(TreeNode t1, TreeNode t2) {
    // simplify
    // if (!t1 || !t2) return t1 ? t1 : t2;
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    
    TreeNode res = new TreeNode(t1.val + t2.val);
    res.left = mergeTrees(t1.left, t2.left);
    res.right = mergeTrees(t1.right, t2.right);
    
    return res;
  }
}
