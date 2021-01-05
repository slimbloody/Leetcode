public class P121_Best_Time_to_Buy_and_Sell_Stock {
  public int maxProfit(int[] prices) {
    return sol1(prices);
  }
  
  // Kadane's Algorithm
  public int sol1(int[] prices) {
    int maxCur = 0, maxSoFar = 0;
    for (int i = 1; i < prices.length; ++i) {
      maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
      maxSoFar = Math.max(maxCur, maxSoFar);
    }
  
    return maxSoFar;
  }
  
  // O(n)
  public int sol2(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int res = 0;
    
    for (int i = 0; i < prices.length; ++i) {
      if (prices[i] <minPrice) {
        minPrice = prices[i];
      }
      else if (prices[i] - minPrice > res) {
        res = prices[i] - minPrice;
      }
    }
    
    return res;
  }
  
  // O(n^2)
  public int sol3(int[] prices) {
    int res = 0;
    for (int i = 0; i < prices.length - 1; ++i) {
      for (int j = i + 1; j < prices.length; ++j) {
        int diff = prices[j] - prices[i];
        res = res < diff ? diff : res;
      }
    }
  
    return res;
  }
  
  public static void main(String[] args) {
    P121_Best_Time_to_Buy_and_Sell_Stock p = new P121_Best_Time_to_Buy_and_Sell_Stock();
    int[] a1 = new int[]{7,1,5,3,6,4};
    System.out.println(p.maxProfit(a1) == 5);
  
    int[] a2 = new int[]{7,6,4,3,1};
    System.out.println(p.maxProfit(a2) == 0);
  }
}
