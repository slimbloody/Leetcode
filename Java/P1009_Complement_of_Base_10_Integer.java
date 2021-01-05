// same as 476_Number_Complement
public class P1009_Complement_of_Base_10_Integer {
  public int bitwiseComplement(int N) {
    return sol3(N);
  }
  
  // N + bitwiseComplement(N) == 11 ... 11 == X
  // bitwiseComplement(N) = X - N
  public int sol1(int N) {
    int X = 1;
    while (X < N) {
      X = ((X << 1) | 1); // x = x * 2 + 1
    }
    return X - N;
  }
  
  // N ^ bitwiseComplement(N) == 11 ... 11 == X
  // bitwiseComplement(N) = N ^ X
  public int sol2(int N) {
    int X = 1;
    while (X < N) {
      X = ((X << 1) + 1);
    }
    return N ^ X;
  }
  
  public int sol3(int N) {
    if (N == 0) {
      return 1;
    }
    int exponenet = (int)(Math.log(N) / Math.log(2)) + 1;
    int flipper = (int)(Math.pow(2, exponenet) - 1);
    return N ^ flipper;
  }
  
  public int sol4(int N) {
    if (N == 0) {
      return 1;
    }
    int mask = N;
    mask |= mask >> 1;
    mask |= mask >> 2;
    mask |= mask >> 4;
    mask |= mask >> 8;
    mask |= mask >> 16;
    return N ^ mask;
  }
  
  public static void main(String[] args) {
    P1009_Complement_of_Base_10_Integer p = new P1009_Complement_of_Base_10_Integer();
    System.out.println(p.bitwiseComplement(5));
    
  }
}
