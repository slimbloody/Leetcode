import java.util.Stack;

public class P1475_Final_Prices_With_a_Special_Discount_in_a_Shop {
  public int[] finalPrices(int[] prices) {
    return sol1(prices);
  }
  
  public int[] sol1(int[] prices) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < prices.length; ++i) {
      while (!stack.empty() && prices[stack.peek()] >= prices[i]) {
        prices[stack.pop()] -= prices[i];
      }
      
      stack.push(i);
    }
    
    return prices;
  }
}
