import java.util.Stack;

public class P938_Range_Sum_of_BST {
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
  
  public int rangeSumBST(TreeNode root, int L, int R) {
    return sol1(root, L, R);
  }
  
  // inorder get value
  public int sol1(TreeNode root, int L, int R) {
    int res = 0;
    if (root == null) {
      return res;
    }
    
    TreeNode cur = root;
  
    Stack<TreeNode> stack = new Stack<>();
    if (cur.right != null) {
      stack.push(cur.right);
    }
    if (cur != null) {
      stack.push(cur.right);
    }
    if (cur.left == null) {
      stack.push(cur.left);
    }
    
    return res;
  }
}
