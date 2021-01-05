public class P1290_Convert_Binary_Number_in_a_Linked_List_to_Integer {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  
  public int getDecimalValue(ListNode head) {
    return sol1(head);
  }
  
  public int sol1(ListNode head) {
    int res = 0;
    
    while (head != null) {
      res = (res << 1 | head.val);
      head = head.next;
    }
    
    return res;
  }
}
