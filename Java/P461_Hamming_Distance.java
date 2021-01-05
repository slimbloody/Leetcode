public class P461_Hamming_Distance {
  public int hammingDistance(int x, int y) {
    return sol1(x, y);
  }
  
  public int sol1(int x, int y) {
    int res = 0;
    while (!(x == 0 && y == 0)) {
      if (((x & 1) ^ (y & 1)) == 1) {
        ++res;
      }
      x >>= 1;
      y >>= 1;
    }
    
    return res;
  }
  
  public int sol2(int x, int y) {
    int res = 0;
    int xor = x ^ y;
    while (xor != 0) {
      res += (xor & 1);
      xor >>= 1;
    }
    
    return res;
  }
  
  // Brian Kernighan’s Algorithm
  // To generalize this behavior, we can say that the operation n & (n-1) removes one set bit from the result. If we do the same operation again with the result, then one more set bit would be removed
  public int sol3(int x, int y) {
    int res = 0, xor = x ^ y;
    while (xor != 0) {
      ++res;
      xor &= xor - 1;
    }
    
    return res;
  }
  
  public int sol4(int x, int y) {
    return Integer.bitCount(x ^ y);
  }
  
  public static void main(String[] args) {
    P461_Hamming_Distance p = new P461_Hamming_Distance();
//    System.out.println(p.hammingDistance(1, 4));
    System.out.println(4 & 3); // 0100 0011
    System.out.println(2 & 3); // 0010 0011
  }
}
