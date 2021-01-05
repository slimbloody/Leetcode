public class P1317_Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers {
  public int[] getNoZeroIntegers(int n) {
    return sol1(n);
  }
  
  // https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/discuss/478216/Java-intuitive-non-brute-force
  public int[] sol1(int n) {
    int low = 0, high = 0, step = 1;
    
    while (n > 0) {
      int d = n % 10;
      n /= 10;
      
      // n>0 evades the case when 1 is the most significant digit
      if ((d == 0 || d == 1) && n > 0) {
        low += step * (1 + d);
        high += step * 9;
        // handle carry
        --n;
      }
      else {
        low += step * 1;
        high += step * (d - 1);
      }
      
      step *= 10;
    }
  
    return new int[]{low, high};
  }
  
  public int[] sol2(int n) {
    int low = 1, high = n - 1;
    
    while (sol2ContainsZero(low) || sol2ContainsZero(high)) {
      ++low;
      --high;
    }
    
    return new int[]{low, high};
  }
  
  private boolean sol2ContainsZero(int num) {
    while(num!=0) {
      int t = num%10;
      if(t == 0) return true;
      num /= 10;
    }
    return false;
  }
}
