import java.util.ArrayList;
import java.util.List;

public class P257_Binary_Tree_Paths {
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
  
  public List<String> binaryTreePaths(TreeNode root) {
    return sol1(root);
  }
  
  public List<String> sol1(TreeNode root) {
    List<String> res = new ArrayList<>();
    
    if (root != null) {
      sol1Helper(root, "", res);
    }
    
    return res;
  }
  
  private void sol1Helper(
    TreeNode root, String path, List<String> res) {
    if (root.left == null && root.right == null) {
      res.add(path + root.val);
    }
    if (root.left != null) {
      sol1Helper(root.left, path + root.val + "->", res);
    }
    if (root.right != null) {
      sol1Helper(root.right, path + root.val + "->", res);
    }
  }
}
