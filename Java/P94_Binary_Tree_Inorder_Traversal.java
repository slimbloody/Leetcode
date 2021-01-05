import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94_Binary_Tree_Inorder_Traversal {
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
  
  public List<Integer> inorderTraversal(TreeNode root) {
    return sol1(root);
  }
  
  // 和前序遍历一样，只不过在访问节点的时候顺序不一样，访问节点的时机是从栈中弹出元素时访问，如果从栈中弹出元素，就意味着当前节点父亲的左子树已经遍历完成，这时候访问父亲，就是中序遍历.
  public List<Integer> sol1(TreeNode root) {
    Stack<TreeNode> s = new Stack<>();
    TreeNode cur = root;
    List<Integer> res = new ArrayList<>();
    
    while (cur != null || !s.empty()) {
      if (cur == null) {
        cur = s.pop();
        res.add(cur.val);
        cur = cur.right;
      }
      else {
        s.push(cur);
        cur = cur.left;
      }
    }
    
    return res;
  }
  
  /*
  public List<Integer> sol1(TreeNode root) {
    Stack<TreeNode> s = new Stack<>();
    TreeNode cur = root;
    List<Integer> res = new ArrayList<>();
    
    while (cur != null || !s.empty()) {
      if (cur == null) {
        cur = s.pop();
        System.out.print("stack: ");
        s.forEach(i -> System.out.print(i.val + " "));
        System.out.println();
        System.out.println(cur.val);
        res.add(cur.val);
        cur = cur.right;
      }
      
      // error: 如果cur.right为null, cur = cur.left 就继续不下去了
      s.push(cur);
      cur = cur.left;
    }
    
    return res;
  }
//  eg:
//  1
//   \
//    2
//   /
//  3
  */
}
