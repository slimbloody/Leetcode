import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P144_Binary_Tree_Preorder_Traversal {
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
  
  public List<Integer> preorderTraversal(TreeNode root) {
    return sol1(root);
  }
  
  public List<Integer> sol1(TreeNode root) {
    Stack<TreeNode> s = new Stack<>();
    List<Integer> res = new ArrayList<>();
    TreeNode cur = root;
    while (cur != null || !s.empty()) {
      if (cur == null) {
        cur = s.pop();
      }
      else {
        res.add(cur.val);
        if (cur.right != null) {
          s.add(cur.right);
        }
        cur = cur.left;
      }
    }
    
    return res;
  }
  
  public List<Integer> sol2(TreeNode root) {
    TreeNode cur = root, pre, temp;
    List<Integer> res = new ArrayList<>();
    
    while (cur != null) {
      if (cur.left == null) {
        res.add(cur.val);
        cur = cur.right;
      }
      else {
        pre = cur.left;
        while (pre.right != null) {
          pre = pre.right;
        }
        pre.right = cur;
        temp = cur;
        cur = cur.left;
        temp.left = null;
      }
    }
    return res;
  }
}
