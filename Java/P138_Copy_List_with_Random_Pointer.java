import java.util.HashMap;
import java.util.Map;

public class P138_Copy_List_with_Random_Pointer {
  class Node {
    int val;
    Node next;
    Node random;
    
    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
  
  public Node copyRandomList(Node head) {
    return sol1(head);
  }
  
  public Node sol1(Node head) {
    Node res = new Node(0);
    Node curRes = res;
    Node cur = head;
    Map<Node, Node> oldToNew = new HashMap<>();
    
    while (cur != null) {
      Node temp = new Node(cur.val);
      curRes.next = temp;
      curRes = curRes.next;
      
      oldToNew.put(cur, temp);
      cur = cur.next;
    }
    
    cur = head;
    curRes = res;
    while (cur != null) {
      curRes.next.random = oldToNew.get(cur.random);
      curRes = curRes.next;
      cur = cur.next;
    }
    
    return res.next;
  }
}
