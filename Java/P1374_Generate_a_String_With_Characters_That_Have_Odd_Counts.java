import java.lang.reflect.Array;
import java.util.Arrays;

public class P1374_Generate_a_String_With_Characters_That_Have_Odd_Counts {
  public String generateTheString(int n) {
    return sol1(n);
  }
  
  public String sol1(int n) {
    char[] res = new char[n];
    Arrays.fill(res, 'a');
    
    if ((n & 1) == 0) {
      res[0] = 'b';
    }
    
    return new String(res);
  }
  
  // bad sol
  public String sol4(int n) {
    StringBuilder sb = new StringBuilder();
    if ((n & 1) == 1) {
      sb.append('a');
      --n;
    }
    
    if (n > 0) {
      sb.append('b');
      for (int i = 0; i < n - 1; ++i) {
        sb.append('c');
      }
    }
    
    return sb.toString();
  }
  
  public static void main(String[] args) {
    P1374_Generate_a_String_With_Characters_That_Have_Odd_Counts p = new P1374_Generate_a_String_With_Characters_That_Have_Odd_Counts();
    System.out.println(p.generateTheString(7));
  }
}
