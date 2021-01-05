public class P234_Palindrome_Linked_List {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
  public boolean isPalindrome(ListNode head) {
    return sol2(head);
  }
  
  public boolean sol1(ListNode head) {
    return true;
  }
  
  public boolean sol2(ListNode head) {
    return true;
  }
}

