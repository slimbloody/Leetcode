import java.util.Arrays;

public class P674_Longest_Continuous_Increasing_Subsequence {
  public int findLengthOfLCIS(int[] nums) {
    return sol1(nums);
  }
  
  // Sliding Window
  // eg: 1 3 5 4 7
  public int sol1(int[] nums) {
    int res = 0, anchor = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (i > 0 && nums[i - 1] >= nums[i]) {
        anchor = i;
      }
      res = Math.max(res, i - anchor + 1);
    }
    
    return res;
  }
  
  public int sol2(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length + 1];
    Arrays.fill(dp , 1);
    
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i - 1] < nums[i]) {
        dp[i] = dp[i - 1] + 1;
      }
    }
    
    return Arrays.stream(dp).max().orElse(0);
  }
  
  public int sol3(int[] nums) {
    if (nums.length == 0){
      return 0;
    }
    
    int index = 0;
    int res = 1;
    int count = 1;
    while (index < nums.length - 1) {
      if (nums[index] < nums[index + 1]) {
        ++count;
      }
      else {
        res = Math.max(count, res);
        count = 1;
      }
      ++index;
    }
    
    res = Math.max(count, res);
    return res;
  }
}
