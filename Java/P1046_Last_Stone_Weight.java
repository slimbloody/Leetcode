import java.util.PriorityQueue;

public class P1046_Last_Stone_Weight {
  public int lastStoneWeight(int[] stones) {
    return sol1(stones);
  }
  
  public int sol1(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
    for (int a : stones) {
      pq.offer(a);
    }
    
    while (pq.size() > 1) {
      int temp = pq.poll() - pq.poll();
      
      if (temp != 0) {
        pq.offer(temp);
      }
    }
    
    return pq.size() == 0 ? 0 : pq.poll();
  }
}
