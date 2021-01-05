public class P326_Power_of_Three {
  public boolean isPowerOfThree(int n) {
    return sol1(n);
  }
  
  // max 3^x, x == 19;
  public boolean sol1(int n) {
    return n > 0 && 1162261467 % n == 0;
  }
  
  // exchange
  public boolean sol2(int n) {
    return (Math.log10(n) / Math.log10(3)) % 1 == 0;
  }
  
  // precision
  public boolean sol3(int n) {
    return n>0 && Math.abs(Math.log10(n)/Math.log10(3)-Math.ceil(Math.log10(n)/Math.log10(3))) < Double.MIN_VALUE;
  }
}
