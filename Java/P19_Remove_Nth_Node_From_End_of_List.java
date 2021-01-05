import java.util.List;

public class P19_Remove_Nth_Node_From_End_of_List {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
  public ListNode removeNthFromEnd(ListNode head, int n) {
    return sol1(head, n);
  }
  
  public ListNode sol1(ListNode head, int n) {
    ListNode cur = new ListNode(0);
    cur.next = head;
    sol1(cur, head, n);
  
    return cur.next;
  }
 
  public Integer sol1(ListNode pre, ListNode cur, int n) {
    if (cur == null) {
      return 0;
    }
    else {
      int sum = 0;
      ListNode ppre = pre;
      pre = cur;
      cur = cur.next;
      sum  = sum + sol1(pre, cur, n) + 1;
      
      if (sum == n) {
        ppre.next = ppre.next.next;
      }
      
      return sum;
    }
  }
  
  public ListNode sol2(ListNode head, int n) {
    sol2Index(head, n);
    return head.next;
  }
  
  public int sol2Index(ListNode node, int n) {
    if (node != null) {
      return 0;
    }
    
    int i = sol2Index(node.next, n) + 1;
    
    if (i > n) {
      node.next.val = node.val;
    }
    
    return i;
  }
  
  // one pass
  // A one pass solution can be done using pointers. Move one pointer fast --> n+1 places forward, to maintain a gap of n between the two pointers and then move both at the same speed. Finally, when the fast pointer reaches the end, the slow pointer will be n+1 places behind - just the right spot for it to be able to skip the next node.
  public ListNode sol3(ListNode head, int n) {
    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    
    for (int i = 0; i < n + 1; ++i) {
      fast = fast.next;
    }
    
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;
    
    return start.next;
  }
  
  // two pass
  // 1: get list len
  // 2: remove (L - n + 1) node
  public ListNode sol4(ListNode head, int n) {
    return new ListNode(0);
  }
  
}


/*
[1,2,3,4,5]
2
[1]
1
 */
