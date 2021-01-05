import java.util.Comparator;
import java.util.PriorityQueue;

public class P747_Largest_Number_At_Least_Twice_of_Others {
  public int dominantIndex(int[] nums) {
    return sol1(nums);
  }
  
  public int sol1(int[] nums) {
    int fir = 0, sec = 0;
    
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] > nums[fir]) {
        sec = fir;
        fir = i;
      }
      else if (nums[i] > nums[sec]) {
        sec = i;
      }
    }
    
    return (fir == sec) ? 0 : (nums[sec] * 2 <= nums[fir]) ? fir : -1;
  }
  
  public int sol2(int[] nums) {
    Comparator<Integer> comparator = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return nums[o2] - nums[o1];
      }
    };
    PriorityQueue<Integer> pq = new PriorityQueue<>(2, comparator);
    for (int i = 0; i < nums.length; ++i) {
      pq.offer(i);
    }
    
    if (pq.size() == 1) {
      return pq.poll();
    }
    else {
      int fir = pq.poll();
      int sec = pq.poll();
      return (nums[fir] >= nums[sec] * 2) ? fir : -1;
      
    }
  }
  
  public static void main(String[] args) {
    P747_Largest_Number_At_Least_Twice_of_Others p = new P747_Largest_Number_At_Least_Twice_of_Others();
    int[] a1 = new int[]{0,0,0,1};
    System.out.println(p.dominantIndex(a1) == 3);
  
    int[] a2 = new int[]{1};
    System.out.println(p.dominantIndex(a2) == 0);
  
    int[] a3 = new int[]{1, 0};
    System.out.println(p.dominantIndex(a3) == 0);
  }
}
