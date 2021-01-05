import java.util.ArrayList;
import java.util.List;

public class P1018_Binary_Prefix_Divisible_By_5 {
  public List<Boolean> prefixesDivBy5(int[] A) {
    return sol1(A);
  }
  
  
  // Observe that we only care about the remainder, not the actual number
  // This would prevent overflows, since new_number is the equivalent
  // representation of the original number in the modular arithemtic of 5
  public List<Boolean> sol1(int[] A) {
    int sum = 0;
    List<Boolean> res = new ArrayList<>();
    
    for (int i = 0; i < A.length; ++i) {
      sum = ((sum << 1) + A[i]) % 5;
      
      if (sum == 0) {
        res.add(true);
      }
      else {
        res.add(false);
      }
    }
    
    return res;
  }
  
  // wrong!
  // overflow
  public List<Boolean> sol2(int[] A) {
    Long sum = 0L;
    List<Boolean> res = new ArrayList<>();
    
    for (int i = 0; i < A.length; ++i) {
      sum = (sum << 1) + A[i];
      
      if (sum % 5 == 0) {
        res.add(true);
      }
      else {
        res.add(false);
      }
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P1018_Binary_Prefix_Divisible_By_5 p = new P1018_Binary_Prefix_Divisible_By_5();
    int[] a1 = {0, 1, 1};
    System.out.println(p.prefixesDivBy5(a1).toString());
  }
}
