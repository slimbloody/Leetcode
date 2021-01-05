import java.util.TreeSet;

public class P220_Contains_Duplicate_III {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    return sol1(nums, k, t);
  }
  
  // This problem requires to maintain a window of size k of the previous values that can be queried for value ranges. The best data structure to do that is Binary Search Tree. As a result maintaining the tree of size k will result in time complexity O(N lg K). In order to check if there exists any value of range abs(nums[i] - nums[j]) to simple queries can be executed both of time complexity O(lg K)
  public boolean sol1(int[] nums, int k, int t) {
    if (nums == null || nums.length == 0 || k <= 0) {
      return false;
    }
    final TreeSet<Integer> values = new TreeSet<>();
    
    for (int i = 0; i < nums.length; ++i) {
      final Integer floor = values.floor(nums[i] + t);
      final Integer ceil = values.ceiling(nums[i] + t);
      
      if ((floor != null) && floor >= nums[i]
        || (ceil != null && ceil <= nums[i])) {
        return true;
      }
      
      values.add(nums[i]);
      if (i >= k) {
        values.remove(nums[i - k]);
      }
    }
    
    return false;
  }
  
  public static void main(String[] args) {
    P220_Contains_Duplicate_III p = new P220_Contains_Duplicate_III();
    
    int[] a1 = new int[]{1,2,3,1};
    System.out.println(p.containsNearbyAlmostDuplicate(a1, 3, 0));
  
    int[] a2 = new int[]{1,0,1,1};
    System.out.println(p.containsNearbyAlmostDuplicate(a2, 1, 2));
  
    int[] a3 = new int[]{1,5,9,1,5,9};
    System.out.println(p.containsNearbyAlmostDuplicate(a3, 2, 3));
  }
}
