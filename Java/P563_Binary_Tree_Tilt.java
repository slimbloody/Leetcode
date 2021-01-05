public class P563_Binary_Tree_Tilt {
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
  
  /*
  https://leetcode.com/problems/binary-tree-tilt/discuss/283387/Insufficient-example.-Please-read-left-%2B-right-%2B-node.value
  I think that explanation and example provided are not sufficient. You need to have a biger tree to explain this problem:
  
  Input :
    4
    / \
    2 9
    / \ \
    3 5 7
  Output : 15
  Explanation:
  Tilt of node 3 : 0
  Tilt of node 5 : 0
  Tilt of node 7 : 0
  Tilt of node 2 : |3-5| = 2
  Tilt of node 9 : |0-7| = 7
  Tilt of node 4 : |(3+5+2)-(9+7)| = 6
  Tilt of binary tree : 0 + 0 + 0 + 2 + 7 + 6 = 15
  */
  
  public int findTilt(TreeNode root) {
    return sol1(root);
  }
  
  private int sol1Res = 0;
  public int sol1(TreeNode root) {
    sol1Helper(root);
    return sol1Res;
  }
  
  private int sol1Helper(TreeNode root) {
    if (root == null) {
      return 0;
    }
  
    int left = sol1Helper(root.left);
    int right = sol1Helper(root.right);
    sol1Res += Math.abs(left - right);
    return left + right + root.val;
  }
}
