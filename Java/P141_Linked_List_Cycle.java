import java.util.HashSet;
import java.util.Set;

public class P141_Linked_List_Cycle {
  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
  
  public boolean hasCycle(ListNode head) {
    return sol1(head);
  }
  
  // Floyd's Tortoise and Hare
  // it takes (distance between 2 runners)/(difference of speed) loops for the difference of speed
  public boolean sol1(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    
    ListNode slow = head;
    ListNode fast = head.next;
    
    while (slow != fast) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    
    return true;
  }
  
  // Brent's algorithm
  public boolean sol2(ListNode head) {
    return true;
  }
  
  // Gosper's algorithm
  public boolean sol3(ListNode head) {
    return false;
  }
  
  // hashtable
  public boolean sol4(ListNode head) {
    Set<ListNode> set = new HashSet<>();
    
    while (head != null) {
      if (set.contains(head)) {
        return true;
      }
      else {
        set.add(head);
      }
      
      head = head.next;
    }
    
    return false;
  }
}

