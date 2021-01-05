public class P53_Maximum_Subarray {
  public int maxSubArray(int[] nums) {
    return sol1(nums);
  }
  
  public int sol1(int[] nums) {
    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    for (int i = 0; i < nums.length; ++i) {
      dp[i + 1] = dp[i] + nums[i] > 0 ? dp[i] + nums[i] : 0;
    }
    
    int max = Integer.MIN_VALUE;
    for (int n: dp){
      if (n > max) {
        max = n;
      }
    }
    
    return max;
  }
}
