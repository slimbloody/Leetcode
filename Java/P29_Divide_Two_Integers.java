public class P29_Divide_Two_Integers {
  public int divide(int dividend, int divisor) {
    return sol1(dividend, divisor);
  }
  
  public int sol1(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    return 1;
  }
  
  public int sol2(int dividend, int divisor) {
    if (dividend == 1 << 31 && divisor == - 1) {
      return (1 << 31) - 1;
    }
  
    return 1;
  }
  
  // O(32)
  public int sol3(int dividend, int divisor) {
    if (dividend == 1 << 31 && divisor == - 1) {
      return (1 << 31) - 1;
    }
    
    int absDividend = Math.abs(dividend);
    int absDivisor = Math.abs(divisor);
    int res = 0;
    
    for (int x = 31; x >= 0; --x) {
      if ((absDividend >>> x) - absDivisor >= 0) {
        res += 1 << x;
        absDividend -= absDivisor << x;
      }
    }
    
    return (absDividend > 0) == (absDivisor > 0) ? res : -res;
  }
  
  public static void main(String[] args) {
    System.out.println((1 << 31));
  }
}
