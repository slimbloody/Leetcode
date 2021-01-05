import java.util.LinkedList;
import java.util.Queue;

public class P117_Populating_Next_Right_Pointers_in_Each_Node_II {
  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    
    public Node() {}
    
    public Node(int _val) {
      val = _val;
    }
    
    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  };
  
  public Node connect(Node root) {
    return sol2(root);
  }
  
  public Node sol1(Node root) {
    Node res = root;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    
    if (root == null) {
      return res;
    }
    
    while (!queue.isEmpty()) {
      int size = queue.size();
      Node pre = null;
      
      for (int i = 0; i < size; ++i) {
        Node temp = queue.poll();
        temp.next = null;
        
        if (i == 0) {
          pre = temp;
        }
        else {
          pre.next = temp;
          pre = temp;
        }
        
        if (temp.left != null) {
          queue.offer(temp.left);
        }
        if (temp.right != null) {
          queue.offer(temp.right);
        }
      }
    }
    
    return res;
  }
  
  public Node sol2(Node root) {
    Node res = root;
    
    while(root != null){
      Node tempChild = new Node(0);
      Node currentChild = tempChild;
      while(root != null) {
        if (root.left != null) {
          currentChild.next = root.left;
          currentChild = currentChild.next;
        }
        if (root.right != null) {
          currentChild.next = root.right;
          currentChild = currentChild.next;
        }
        root = root.next;
      }
      root = tempChild.next;
    }
    return res;
  }
}

