import java.util.PriorityQueue;
import java.util.TreeSet;

public class P414_Third_Maximum_Number {
  public int thirdMax(int[] nums) {
    return sol1(nums);
  }
  
  // sol1: TreeSet
  public int sol1(int[] nums) {
    TreeSet<Integer> ts = new TreeSet<>();
    
    for (int n: nums) {
      ts.add(n);
      
      if (ts.size() > 3) {
        ts.pollFirst();
      }
    }
    
    return ts.size() < 3 ? ts.last() : ts.first();
  }
  
  // sol2: priority queue
  // The head of this queue is the least element with respect to
  // the specified ordering
  public int sol2(int[] nums) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
    
    for (int n: nums) {
      pq.add(n);
      
      if (pq.size() > 3) {
        pq.poll();
      }
    }
    
    Integer[] A = new Integer[pq.size()];
    pq.toArray(A);
  
    return pq.size() < 3 ? A[A.length - 1] : pq.poll();
  }
  
  public int sol3(int[] nums) {
    Integer first = null, second = null, third = null;
    
    for (Integer n: nums) {
      if (n.equals(first) || n.equals(second) || n.equals(third)) {
        continue;
      }
      if (first == null || n > first ) {
        third = second;
        second = first;
        first = n;
      }
      else if (second == null || n > second) {
        third = second;
        second = n;
      }
      else if (third == null || n > third) {
        third = n;
      }
    }
    
    return third == null ? first : third;
  }
}
