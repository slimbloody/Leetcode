public class P746_Min_Cost_Climbing_Stairs {
  public int minCostClimbingStairs(int[] cost) {
    return sol1(cost);
  }
  
  // dp[n] = max(dp[n - 1], dp[n2 - 2]);
  public int sol1(int[] cost) {
    int[] dp = new int[cost.length + 1];
    dp[0] = 0;
    dp[1] = 0;
    
    for (int i = 2; i < cost.length + 1; ++i) {
      dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
    }
    
    return dp[cost.length];
  }
  
  public static void main(String[] args) {
    P746_Min_Cost_Climbing_Stairs p = new P746_Min_Cost_Climbing_Stairs();
    int[] a1 = new int[]{10, 15, 20};
    System.out.println(p.minCostClimbingStairs(a1));
  
    int[] a2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    System.out.println(p.minCostClimbingStairs(a2));
  }
}
