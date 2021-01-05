public class P693_Binary_Number_with_Alternating_Bits {
  public boolean hasAlternatingBits(int n) {
    return sol6(n);
  }
  
  public boolean sol1(int n) {
    /*
    n =         1 0 1 0 1 0 1 0
    n >> 1      0 1 0 1 0 1 0 1
    n ^ n>>1    1 1 1 1 1 1 1 1
    n           1 1 1 1 1 1 1 1
    n + 1     1 0 0 0 0 0 0 0 0
    n & (n+1)   0 0 0 0 0 0 0 0
    */
    n = n ^ (n >> 1);
    return (n & n + 1) == 0;
  }
  
  public boolean sol6(int n) {
    return (n & (n >> 1)) == 0 && (n & (n >> 2)) == (n >> 2);
  }
  
  public boolean sol7(int n) {
    String bits = Integer.toBinaryString(n);
    for (int i = 0; i < bits.length() - 1; i++) {
      if (bits.charAt(i) == bits.charAt(i+1)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean sol8(int n) {
    int cur = 0, pre = -1;
    while(n != 0) {
      cur = n & 1;
      if(cur == pre) return false;
      n >>>= 1;
      pre = cur;
    }
    return true;
  }

  public boolean sol9(int n) {
    int prev = -1;
    
    while (n != 0) {
      int temp = n & 1;
      if (prev == -1) {
        prev = temp;
      }
      else {
        if ((temp ^ prev) == 1) {
          prev = temp;
        }
        else {
          return false;
        }
      }
      n >>= 1;
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    P693_Binary_Number_with_Alternating_Bits p = new P693_Binary_Number_with_Alternating_Bits();
    System.out.println(p.hasAlternatingBits(5));
    System.out.println(!p.hasAlternatingBits(7));
    System.out.println(p.hasAlternatingBits(1));
    System.out.println(!p.hasAlternatingBits(3));
  }
}
