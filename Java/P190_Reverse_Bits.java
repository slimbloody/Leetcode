public class P190_Reverse_Bits {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    return sol1(n);
  }
  
  public int sol1(int n) {
    return Integer.parseInt(
        new StringBuilder(
            String
                .format("%032s", Integer.valueOf(n).toString()))
            .reverse()
            .toString()
    );
  }
  
  public static void main(String[] args) {
  }
}
