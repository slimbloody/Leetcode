import java.util.ArrayList;
import java.util.List;

public class P655_Print_Binary_Tree {
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
  
  public List<List<String>> printTree(TreeNode root) {
    return new ArrayList<>();
  }
}
