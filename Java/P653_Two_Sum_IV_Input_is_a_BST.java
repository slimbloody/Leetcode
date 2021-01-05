public class P653_Two_Sum_IV_Input_is_a_BST {
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
 
  public boolean findTarget(TreeNode root, int k) {
   return sol1(root, k);
  }
  
  // check if k - node.val exists in this BST
  // Time Complexity: O(nh), Space Complexity: O(h)
  public boolean sol1(TreeNode root, int k) {
   while (root != null) {
     if (root.val == k) {
       return true;
     }
     else if (root.val > k) {
       root = root.left;
     }
     else {
       root = root.right;
     }
   }
   
   return false;
  }
  
  // inorder traversal get an array, then two pointer to get ans
  public boolean sol2(TreeNode root, int k) {
   return true;
  }
  
  // traversal and get a hashtable, check if (k - temp_value) in hashtable
  public boolean sol3(TreeNode root, int k) {
    return true;
  }
}
