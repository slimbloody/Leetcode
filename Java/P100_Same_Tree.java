import java.util.LinkedList;
import java.util.Queue;

public class P100_Same_Tree {
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
  
  public boolean isSameTree(TreeNode p, TreeNode q) {
    return sol2(p, q);
  }
  
  public boolean sol1(TreeNode p, TreeNode q) {
    if (p != null && q != null) {
      return p.val == q.val
          && sol1(p.left, q.left)
          && sol1(p.right, q.right);
    }
    else if (p == null && q == null)  {
      return true;
    }
    else {
      return false;
    }
  }
  
  public boolean check(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    else if (p != null && q != null) {
      return p.val == q.val;
    }
    else {
      return false;
    }
  }
  public boolean sol2(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (!check(p, q)) {
      return false;
    }
    Queue<TreeNode> deqP = new LinkedList<>();
    Queue<TreeNode> deqQ = new LinkedList<>();
    deqP.offer(p);
    deqQ.offer(q);
  
    while (!deqP.isEmpty()) {
      p = deqP.poll();
      q = deqQ.poll();
    
      if (!check(p, q)) return false;
      if (p != null) {
        // in Java nulls are not allowed in Deque
        if (!check(p.left, q.left)) return false;
        if (p.left != null) {
          deqP.offer(p.left);
          deqQ.offer(q.left);
        }
        if (!check(p.right, q.right)) return false;
        if (p.right != null) {
          deqP.offer(p.right);
          deqQ.offer(q.right);
        }
      }
    }
    
    return true;
  }
}
