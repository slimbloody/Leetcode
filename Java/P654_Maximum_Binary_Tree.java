import java.util.Arrays;

public class P654_Maximum_Binary_Tree {
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
  
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return sol1(nums);
  }
  
  public TreeNode sol1(int[] nums) {
    int index = -1, max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] > max) {
        index = i;
        max = nums[i];
      }
    }
    if (index == -1) {
      return null;
    }
    TreeNode res = new TreeNode(max);
    
    res.left = sol1(
      Arrays.copyOfRange(nums, 0, index)
    );
    res.right = sol1(
      Arrays.copyOfRange(nums, index + 1, nums.length)
    );
    
    return res;
  }
  
  // better solution
  // left right to avoid array copy
  public TreeNode sol2(int[] nums, int left, int right) {
    TreeNode res = new TreeNode();
    return res;
  }
  
  // the array is inorder traversal
  public TreeNode sol3(int[] nums, int left, int right) {
    TreeNode res = new TreeNode();
    return res;
  }
}
