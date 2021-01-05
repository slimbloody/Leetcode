public class P367_Valid_Perfect_Square {
  public boolean isPerfectSquare(int num) {
    return sol1(num);
  }
  
  // Newton Method
  public boolean sol1(int num) {
    long r = num;
    while (r * r > num) {
      r = (r + num / r) >> 1;
    }
    
    return r * r == num;
  }
  
  // 完全平方数是一系列奇数之和
  public boolean sol2(int num) {
    int i = 1;
    
    while (num > 0) {
      num -= i;
      i += 2;
    }
    
    return num == 0;
  }
  
  // The time complexity is O(sqrt(n)), a more efficient one using binary search whose time complexity is O(log(n)):
  public boolean sol3(int num) {
    int low = 1, high = num;
    while (low <= high) {
      long mid = (low + high) >>> 1;
      if (mid * mid == num) {
        return true;
      }
      else if (mid * mid < num) {
        low = (int) mid + 1;
      }
      else {
        high = (int) mid - 1;
      }
    }
    
    return false;
  }
}
