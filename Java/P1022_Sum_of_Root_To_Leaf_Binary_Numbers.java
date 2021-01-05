public class P1022_Sum_of_Root_To_Leaf_Binary_Numbers {
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
  public int sumRootToLeaf(TreeNode root) {
    return getValue(root, String.valueOf(root.val));
  }
  
  private int getValue(TreeNode cur, String strVal) {
    if (cur == null) {
      return 0;
    }
    if (cur.left == null && cur.right == null) {
      System.out.println(strVal);
      return Integer.parseInt(strVal, 2);
    }
    else {
      int left = cur.left != null ?
          getValue(cur.left, strVal + String.valueOf(cur.left.val)) : 0;
      int right = cur.right != null ?
          getValue(cur.right, strVal + String.valueOf(cur.right.val)) : 0;
      return left + right;
    }
  }
}
