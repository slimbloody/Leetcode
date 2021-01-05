public class P143_Reorder_List {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  
  public void reorderList(ListNode head) {
    sol1(head);
  }
  
  public void sol1(ListNode head) {
    int counter = 0;
    ListNode cur = head;
    while (cur != null) {
      ++counter;
      cur = cur.next;
    }
  
    int prevNum = counter - counter / 2;
  }
}
