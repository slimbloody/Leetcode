public class P191_Number_of_1_Bits {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    return sol1(n);
  }
  
  public int sol1(int n) {
    int count = 0;
    
    while (n != 0) {
      count = count + (n & 1);
      n = n >> 1;
    }
    
    return count;
  }
  
  public int sol2(int n) {
    return 1;
  }
}
