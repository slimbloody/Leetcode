import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class P23_Merge_k_Sorted_Lists {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val =  val; this.next = next; }
  }
  
  
  public ListNode mergeKLists(ListNode[] lists) {
    return sol1(lists);
  }
  
  public ListNode sol1(ListNode[] lists) {
    ListNode res = new ListNode(), cur = res;
    int maxIndex;
    List<ListNode> list = Arrays
        .stream(lists)
        .filter(Objects::nonNull)
        .parallel()
        .collect(Collectors.toList());
  
    while (!list.isEmpty()) {
      maxIndex = -1;
      for (int i = 0; i < list.size(); ++i) {
        if (maxIndex == -1 || list.get(i).val < list.get(maxIndex).val) {
          maxIndex = i;
        }
      }
      
      cur.next = list.get(maxIndex);
      list.set(maxIndex, list.get(maxIndex).next);
      if (list.get(maxIndex) == null) {
        list.remove(maxIndex);
      }
      cur = cur.next;
      cur.next = null;
    }
    
    return res.next;
  }
}
