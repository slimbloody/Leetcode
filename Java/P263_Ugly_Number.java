public class P263_Ugly_Number {
  public boolean isUgly(int num) {
    return sol1(num);
  }
  
  public boolean sol1(int num) {
    if (num == 1) {
      return true;
    }
    if(num == 0) {
      return false;
    }
    while (num%2 == 0) {
      num >>= 1;
    }
    while (num%3 == 0) {
      num /= 3;
    }
    while (num%5==0) {
      num /= 5;
    }
    return num == 1;
  }
  
}
