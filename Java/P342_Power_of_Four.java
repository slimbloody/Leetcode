public class P342_Power_of_Four {
  public boolean isPowerOfFour(int num) {
    return sol1(num);
  }
  
  // shift
  public boolean sol1(int num) {
    return Integer.toString(num, 4).matches("10*");
  }
  
  // math log
  public boolean sol2(int num) {
    return Math.log(num) / Math.log(4) % 1  == 0;
  }
  
  // math
  // max int 2^32 / 2 - 1 2^30
  public boolean sol3(int num) {
    return (2^30 % num) == 0;
  }
}
