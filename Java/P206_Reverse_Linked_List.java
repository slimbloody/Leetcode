public class P206_Reverse_Linked_List {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  
  public ListNode reverseList(ListNode head) {
    ListNode cur = head;
    ListNode newHead = new ListNode();
    newHead.next = null;
    
    while (head != null) {
      ListNode temp = head;
      head = head.next;
      
      temp.next = newHead.next;
      newHead.next = temp;
    }
    
    return null;
  }
}
