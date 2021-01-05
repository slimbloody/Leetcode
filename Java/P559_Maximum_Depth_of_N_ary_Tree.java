import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P559_Maximum_Depth_of_N_ary_Tree {
  class Node {
    public int val;
    public List<Node> children;
    
    public Node() {}
    
    public Node(int _val) {
      val = _val;
    }
    
    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  };
  
  public int maxDepth(Node root) {
    return sol1(root);
  }
  
  public int sol1(Node root) {
    if (root == null) {
      return 0;
    }
    else {
      int maxDepth = 0;
      for (Node n: root.children) {
        int tempDepth = maxDepth(n);
        maxDepth = Math.max(maxDepth, tempDepth);
      }
      
      return maxDepth + 1;
    }
  }
  
  public int sol2(Node root) {
    if(root == null) {
      return 0;
    }
    
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    
    int depth = 0;
    
    while(!queue.isEmpty()) {
      int size = queue.size();
      
      for(int i = 0; i < size; i++) {
        Node current = queue.poll();
        for(Node child: current.children) {
          queue.offer(child);
        }
      }
      
      ++depth;
    }
    
    return depth;
  }
}
