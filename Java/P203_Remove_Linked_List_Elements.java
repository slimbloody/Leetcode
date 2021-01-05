public class P203_Remove_Linked_List_Elements {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  
  public ListNode removeElements(ListNode head, int val) {
    return sol2(head, val);
  }
  
  public ListNode sol1(ListNode head, int val) {
    ListNode preRes = new ListNode();
    preRes.next = head;
    ListNode cur = preRes;
    
    while (cur.next != null) {
      if (cur.next.val == val) {
        cur.next = cur.next.next;
      }
      else {
        cur = cur.next;
      }
    }
    
    return preRes.next;
  }
  
  public ListNode sol2(ListNode head, int val) {
    if (head == null) {
      return null;
    }
    head.next = sol2(head.next, val);
    return head.val == val ? head.next : head;
  }
}
