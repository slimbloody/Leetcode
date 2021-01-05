import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P523_Continuous_Subarray_Sum {
  public boolean checkSubarraySum(int[] nums, int k) {
    return sol2(nums, k);
  }
  
  // Math: c = a % k, c = b % k, so we have a % k = b % k.
  // Let me know if there is any better one.
  // In short, start with mod =0, then we always do mod = (mod+nums[i])%k, if mod repeats, that means between these two mod = x occurences the sum is multiple of k.
  public boolean sol1(int[] nums, int k) {
    if (nums.length <= 1) {
      return false;
    }
    for (int i = 0; i < nums.length - 1; ++i) {
      if (nums[i] == 0 && nums[i + 1] == 0) {
        return true;
      }
    }
    
    if (k == 0) {
      return false;
    }
    
    Set<Integer> set = new HashSet<>();
    int sum = 0;
  
    int preSize = set.size(), remainder = 0;
    for (int i = 0; i < nums.length; ++i) {
      remainder += nums[i];
    
      if (k != 0) {
        remainder %= k;
        set.add(sum);
      }
      if (preSize + 1 != set.size()) {
        return true;
      }
      else {
        preSize = set.size();
      }
    }
  
    return false;
  }
  
  public boolean sol2(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0, pre = 0;
    
    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];
      int mod = k == 0 ? sum : sum % k;
      if (map.get(mod) != null) {
        return true;
      }
      map.put(pre, 1);
      pre = mod;
    }
    
    return false;
  }
}
