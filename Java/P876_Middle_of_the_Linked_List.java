public class P876_Middle_of_the_Linked_List {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  
  public ListNode middleNode(ListNode head) {
    return sol1(head);
  }
  
  public ListNode sol1(ListNode head) {
    ListNode slow = head, fast = head;
    
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    
    return slow;
  }
}
