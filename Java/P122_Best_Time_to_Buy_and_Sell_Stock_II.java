import java.util.ArrayList;
public class P122_Best_Time_to_Buy_and_Sell_Stock_II {
  public int maxProfit(int[] prices) {
    return sol1(prices);
  }
  // tag: 求n个最长上升子序列的长度之和
  
  public int sol1(int[] prices) {
    return 1;
  }
  
  public int sol2(int[] prices) {
    int index = 0;
    int res = 0;
    
    while (index < prices.length) {
      int counter = 0;
      while (index + counter < prices.length - 1
          && prices[index + counter] < prices[index + counter + 1]) {
        ++counter;
      }
  
      res += prices[index + counter] - prices[index];
      index = index + counter + 1;
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P122_Best_Time_to_Buy_and_Sell_Stock_II p = new P122_Best_Time_to_Buy_and_Sell_Stock_II();
    int[] a1 = new int[]{7,1,5,3,6,4};
    System.out.println(p.maxProfit(a1));
  
    int[] a2 = new int[]{1,2,3,4,5};
    System.out.println(p.maxProfit(a2));
  
    int[] a3 = new int[]{7,6,4,3,1};
    System.out.println(p.maxProfit(a3));
  }
}
