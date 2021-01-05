import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 
public class P637_Average_of_Levels_in_Binary_Tree {
  public List<Double> averageOfLevels(TreeNode root) {
    return sol1(root);
  }
  
  // queue is a better choice
  public List<Double> sol1(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Double> output = new ArrayList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
      int count = queue.size();
      double sum = 0;
      
      for (int i = 0; i < count; ++i) {
        TreeNode node = queue.poll();
        sum += node.val;
        if (node.left != null) {
          queue.offer(node.left);
        }
  
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      output.add(sum / count);
    }
    
    return output;
  }
  
  // use array is tedious
  public List<Double> sol2(TreeNode root) {
    List<TreeNode> level = new ArrayList<>();
    List<Double> output = new ArrayList<>();
    
    level.add(root);
    
    while (level.size() != 0) {
      double sum = 0;
      List<TreeNode> temp = new ArrayList<>();
      int count =level.size();
  
      for (TreeNode elem : level) {
        if (elem.left != null) {
          temp.add(elem.left);
        }
        if (elem.right != null) {
          temp.add(elem.right);
        }
        sum = sum + elem.val;
      }
  
      output.add(sum / count);
      level = temp;
    }
    
    return output;
  }
}









