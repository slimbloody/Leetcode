public class P714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
  public int maxProfit(int[] prices, int fee) {
    return sol2(prices, fee);
  }
  
  // (rest)buy - sell - (rest)buy - sell
  public int sol2(int[] prices, int fee) {
    if (prices.length == 0) {
      return 0;
    }
    // We can create 4 variables, one for each state excluding the initial state since that's always 0, initializing s1 to -prices[0] and the rest to INT_MIN since they will get overwritten later
    
    int s1 = - prices[0];
    int s2 = Integer.MIN_VALUE;
    int s3 = Integer.MIN_VALUE;
    int s4 = Integer.MIN_VALUE;
    
    // essence: Side Note: Technically, this is a dynammic programming approach and we should actually be doing s2[i] = max(s2[i-1], s1[i-1]+prices[i]) but we can be rest assured that the overwritten value of s1 will always be better than the previous one and hence we do not need temporary variables.
    for (int i = 1; i < prices.length; ++i) {
      s1 = Math.max(s1, -prices[i]);
      s2 = Math.max(s2, s1 + prices[i]);
      s3 = Math.max(s3, s2 - prices[i]);
      s4 = Math.max(s2, s3 + prices[i]);
    }
    
    return Math.max(0, s4);
  }
}
