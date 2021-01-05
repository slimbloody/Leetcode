public class P83_Remove_Duplicates_from_Sorted_List {
  class ListNode {
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
    ListNode cur = head;
    
    while (cur != null && cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      }
      else {
        cur = cur.next;
      }
    }
  
    return head;
  }
  
  // recursive
  public ListNode sol2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    
    head.next = sol2(head.next);
    return head.val == head.next.val ? head.next : head;
  }
}

