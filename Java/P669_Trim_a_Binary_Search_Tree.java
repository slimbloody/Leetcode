public class P669_Trim_a_Binary_Search_Tree {
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
 
 public TreeNode trimBST(TreeNode root, int L, int R) {
   return sol1(root, L, R);
 }
  
  public TreeNode sol1(TreeNode root, int L, int R) {
   return null;
  }
}
