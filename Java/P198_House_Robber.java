import java.util.Arrays;

public class P198_House_Robber {
  /*
  Find recursive relation
  Recursive (top-down)
  Recursive + memo (top-down)
  Iterative + memo (bottom-up)
  Iterative + N variables (bottom-up)
  
  critical:
  rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )
  */
  
  public int rob(int[] nums) {
    return sol2(nums);
  }
  
  public int sol1(int[] nums) {
    return 1;
  }
  
  public int sol2(int[] nums) {
    int[] dp = new int[nums.length];
  
    dp[0] = 0;
    if (nums.length == 0) {
      return dp[0];
    }
  
    dp[1] = nums[0];
    if (nums.length == 1) {
      return dp[1];
    }
    
    
    for (int i = 2; i < nums.length; ++i) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
  
    System.out.println(Arrays.toString(dp));
    return dp[nums.length - 1];
  }
  
  
  public int sol3(int[] nums) {
    int[][] dp = new int[nums.length + 1][2];
    
    // dp[i][1] means we rob the current house and dp[i][0] means we don't
    for (int i = 1; i < nums.length; ++i) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
      dp[i][1] = nums[i - 1] + dp[i - 1][0];
    }
    
    return Math.max(dp[nums.length][0], dp[nums.length][1]);
  }
  
  // sol3 evolve
  public int sol4(int[] nums) {
    int preNo = 0;
    int preYes = 0;
    
    for (int n: nums) {
      int temp = preNo;
      preNo = Math.max(preNo, preYes);
      preYes = n + temp;
    }
    
    return Math.max(preNo, preYes);
  }
  
  public int sol5(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int prev1 = 0, prev2 = 0;
    
    for (int num: nums) {
      int tmp = prev1;
      prev1 = Math.max(prev2 + num, prev1);
      prev2 = tmp;
    }
    
    return prev1;
  }
  
  public static void main(String[] args) {
    P198_House_Robber p = new P198_House_Robber();
    int[] a1 = new int[]{2,1,1,2};
    System.out.println(p.rob(a1));
  }
}

