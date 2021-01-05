public class P231_Power_of_Two {
  public boolean isPowerOfTwo(int n) {
    return sol1(n);
  }
  
  public boolean sol1(int n) {
    return n > 0 && Integer.bitCount(n) == 1;
  }
}
