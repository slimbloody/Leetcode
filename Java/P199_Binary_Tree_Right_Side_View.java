import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P199_Binary_Tree_Right_Side_View {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  
  public List<Integer> rightSideView(TreeNode root) {
    return sol1(root);
  }
  
  // level order traversal and pick the last element
  public List<Integer> sol1(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    
    if (root == null) {
      return res;
    }
  
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
  
    while (!queue.isEmpty()) {
      int levelLen = queue.size();
      for (int i = 0; i < levelLen; ++i) {
        TreeNode temp = queue.poll();
        if (i == levelLen - 1) {
          res.add(temp.val);
        }
        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
    }
    
    return res;
  }
  
  // recursive
  public List<Integer> sol2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    sol2(root, res, 0);
    return res;
  }
  
  public void sol2(TreeNode cur, List<Integer> res, int curDepth) {
    if (cur == null) {
      return;
    }
    if (curDepth == res.size()) {
      res.add(cur.val);
    }
    
    sol2(cur.right, res, curDepth + 1);
    sol2(cur.left, res, curDepth + 1);
  }
}
