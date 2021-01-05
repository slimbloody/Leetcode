import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P872_Leaf_Similar_Trees {
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
  
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    return sol1(root1, root2);
  }
  
  public boolean sol1(TreeNode root1, TreeNode root2) {
    List<Integer> l1 = sol1GetLeave(root1);
    List<Integer> l2 = sol1GetLeave(root2);
    return l1.equals(l2);
  }
  
  public List<Integer> sol1GetLeave(TreeNode root) {
    List<Integer> l = new ArrayList<>();
    Stack<TreeNode> s = new Stack<>();
    TreeNode cur = root;
  
    while (cur != null || !s.empty()) {
      while (cur != null) {
        if (cur.left == null && cur.right == null) {
          l.add(cur.val);
        }
      
        s.push(cur);
        cur = cur.left;
      }
    
      if (!s.empty()) {
        cur = s.pop();
        cur = cur.right;
      }
    }
    
    return l;
  }
  
  public boolean sol2(TreeNode root1, TreeNode root2) {
    Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
    s1.push(root1);
    s2.push(root2);
    
    while (!s1.empty() && !s2.empty()) {
      if (sol2GetLeave(s1) != sol2GetLeave(s2)) {
        return false;
      }
    }
    
    return s1.empty() && s2.empty();
  }
  
  // Here I share an idea of comparing node by node using O(H) space,
  // where H is the height of the tree.
  // Only O(H) space for stack, no extra space for comparation.
  // O(1) is also possible if we can modify the tree.
  public int sol2GetLeave(Stack<TreeNode> s) {
    while (true) {
      TreeNode temp = s.pop();
      if (temp.right != null) {
        s.push(temp.right);
      }
      if (temp.left != null) {
        s.push(temp.left);
      }
      if (temp.left == null && temp.right == null) {
        return temp.val;
      }
    }
  }
  
  /*
  class Solution(object):
    def leafSimilar(self, root1, root2):
      """
      :type root1: TreeNode
          :type root2: TreeNode
          :rtype: bool
          """
            return self.findleaf(root1) == self.findleaf(root2)
    
    def findleaf(self, root):
      if not root: return []
      if not (root.left or root.right): return [root.val]
      return self.findleaf(root.left) + self.findleaf(root.right)
   */
}
