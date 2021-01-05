public class P24_Swap_Nodes_in_Pairs {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  
  public ListNode swapPairs(ListNode head) {
    return sol1(head);
  }
  
  public ListNode sol1(ListNode head) {
    ListNode res = new ListNode();
    ListNode cur = res;
    ListNode pre, post;
    while (head != null && head.next != null) {
      pre = head;
      post = head.next;
      head = head.next.next;
      
      cur.next = post;
      cur.next.next = pre;
      cur = cur.next.next;
    }
    cur.next = head;
    
    return res.next;
  }
}
