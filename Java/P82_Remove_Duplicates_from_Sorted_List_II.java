public class P82_Remove_Duplicates_from_Sorted_List_II {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  
  public ListNode deleteDuplicates(ListNode head) {
    return sol1(head);
  }
  
  public ListNode sol1(ListNode head) {
    ListNode res = new ListNode(), pre = new ListNode(), cur = res;
    res.next = null;
    boolean removeHead = false;
    
    while (head != null || removeHead) {
      while (cur.next != null && head != null && head.val == cur.next.val) {
        head = head.next;
        removeHead = true;
      }
      
      if (removeHead) {
        removeHead = false;
        cur = pre;
        cur.next.next = null;
      }
      else {
        if (cur.next == null) {
          cur.next = head;
          head = head.next;
          cur.next.next = null;
          pre.next = cur;
        }
        else {
          cur.next.next = head;
          head = head.next;
          pre = cur;
          cur = cur.next;
          cur.next.next = null;
        }
      }
    }
    
    return res.next;
  }
  
  public ListNode sol2(ListNode head) {
    ListNode res = new ListNode(0), fast = head, slow = res;
    slow.next = fast;
    
    while (fast != null) {
      // while loop to find the last node of the dups.
      while (fast.next != null && fast.val == fast.next.val) {
        fast = fast.next;
      }
      
      // while loop to find the last node of the dups.
      if (slow.next !=  fast) {
        slow.next = fast.next;
        fast = slow.next;
      }
      // no dup, move down both pointer.
      else {
        slow = slow.next;
        fast = fast.next;
      }
    }
    
    return res.next;
  }
  
}
/*
[1,2,3,3,4,4,5]
[1,1,1,2,3]
[1,1]
 */
