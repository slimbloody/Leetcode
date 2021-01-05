public class P70_Climbing_Stairs {
  public int climbStairs(int n) {
    return sol2(n);
  }
  
  public int sol1(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    
    for (int i = 2; i < n + 1; ++i) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    
    return dp[n];
  }
  
  // rotate array
  public int sol2(int n) {
    int d1 = 1, d2 = 1;
    
    for (int i = 2; i < n + 1; ++i) {
      int temp = d2;
      d2 = d1 + d2;
      d1 = temp;
    }
    
    return d2;
  }
  
  public static void main(String[] args) {
    P70_Climbing_Stairs p = new P70_Climbing_Stairs();
    System.out.println(p.climbStairs(2));
    System.out.println(p.climbStairs(3));
  }
}
