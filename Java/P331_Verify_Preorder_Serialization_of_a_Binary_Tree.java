import java.util.Stack;

public class P331_Verify_Preorder_Serialization_of_a_Binary_Tree {
  class TreeNode {
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
  
  public boolean isValidSerialization(String preorder) {
    return sol1(preorder);
  }
  
  public boolean sol1(String preorder) {
//    Stack<TreeNode>
      return true;
  }
}
