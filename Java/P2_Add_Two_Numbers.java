import java.util.List;

public class P2_Add_Two_Numbers {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val =  val; this.next = next; }
  }
  
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return sol1(l1, l2);
  }
  
  public ListNode sol1(ListNode l1, ListNode l2) {
    ListNode res = new ListNode();
    ListNode cur = res;
    int carry = 0;
    int temp;
    
    while (l1 != null && l2 != null) {
      temp = l1.val + l2.val + carry;
      carry = 0;
      l1 = l1.next;
      l2 = l2.next;
      
      if (temp > 9) {
        carry = 1;
        temp -= 10;
      }
      
      cur.next = new ListNode(temp);
      cur = cur.next;
    }
    while (l1 != null) {
      temp = l1.val + carry;
      l1 = l1.next;
      carry = 0;
  
      if (temp > 9) {
        carry = 1;
        temp -= 10;
      }
  
      cur.next = new ListNode(temp);
      cur = cur.next;
    }
    while (l2 != null) {
      temp = l2.val + carry;
      l2 = l2.next;
      carry = 0;
    
      if (temp > 9) {
        carry = 1;
        temp -= 10;
      }
    
      cur.next = new ListNode(temp);
      cur = cur.next;
    }
    
    if (carry == 1) {
      cur.next = new ListNode(1);
    }
    
    return res.next;
  }
}
