import java.util.List;

public class P112_Path_Sum {
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
 
  public boolean hasPathSum(TreeNode root, int sum) {
   return sol1(root, sum);
  }
  
  public boolean sol1(TreeNode root, int sum) {
   return true;
  }
  
  public List<List<TreeNode>> getAllPath(List<TreeNode> path, TreeNode temp) {
   return null;
  }
}
