import javax.security.auth.login.AccountException;

public class P1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {
  public int[] smallerNumbersThanCurrent(int[] nums) {
    return sol1(nums);
  }
  
  // sol1: bucket sort: O(n)
  public int[] sol1(int[] nums) {
    int[] res = new int[nums.length];
    int[] bucket = new int[101];
    
    for (int i = 0; i < nums.length; ++i) {
      ++bucket[nums[i]];
    }
    
    for (int i = 1; i <= 100; ++i) {
      bucket[i] += bucket[i - 1];
    }
  
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == 0) {
        res[i] = 0;
      }
      else {
        res[i] = bucket[nums[i] - 1];
      }
    }
    
    return res;
    
  }
  
  // sol2: sort and get index: O(nlogn)
}
