import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P219_Contains_Duplicate_II {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    return sol1(nums, k);
  }
  
  public boolean sol1(int[] nums, int k) {
    Map<Integer, Integer > map = new HashMap<>();
    
    for (int i = 0; i < nums.length; ++i) {
      if (map.containsKey(nums[i])) {
        if (i - map.get(nums[i]) <= k) {
          return true;
        }
      }
    }
    
    return false;
  }
  
//  Explanation: It iterates over the array using a sliding window. The front of the window is at i, the rear of the window is k steps back. The elements within that window are maintained using a Set. While adding new element to the set, if add() returns false, it means the element already exists in the set. At that point, we return true. If the control reaches out of for loop, it means that inner return true never executed, meaning no such duplicate element was found.
  public boolean sol2(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    
    for (int i = 0; i < nums.length; ++i) {
      if (i > k) {
        set.remove(nums[i - k - 1]);
      }
      if (!set.add(nums[i])) {
        return true;
      }
    }
    return false;
  }
}
