import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P989_Add_to_Array_Form_of_Integer {
  public List<Integer> addToArrayForm(int[] A, int K) {
    return sol1(A, K);
  }
  
  public List<Integer> sol2(int[] A, int K) {
    List res = new ArrayList<>();
    
    // 0 <= K <= 10000, K's unit is the key matter
    for (int i = A.length - 1; i >= 0 || K > 0; --i) {
      res.add(0, (i >= 0 ? A[i] + K : K) % 10);
      K = (i >= 0 ? A[i] + K : K) / 10;
    }
    
    return res;
  }
  
  public List<Integer> sol1(int[] A, int K) {
    LinkedList<Integer> output = new LinkedList<>();
    int carry = 0;
    int i = A.length - 1;
    
    while (K > 0 || i >= 0 || carry == 1) {
      int temp = 0;
      
      if (K > 0) {
        temp = temp + K % 10;
        K /= 10;
      }
      
      if (i >= 0) {
        temp = temp + A[i--];
      }
      
      if (carry == 1) {
        temp = temp + carry;
        carry = 0;
      }
  
      if (temp >= 10) {
        temp -= 10;
        carry = 1;
      }
      else {
        carry = 0;
      }
  
      output.addFirst(temp);
    }
    
    return output;
  }
  
  
  public static void main(String[] args) {
    P989_Add_to_Array_Form_of_Integer p = new P989_Add_to_Array_Form_of_Integer();
    int[] a1 = {1, 2, 0, 0};
    System.out.println(p.addToArrayForm(a1, 34).toString());
  
    int[] a2 = {2, 1, 5};
    System.out.println(p.addToArrayForm(a2, 806).toString());
  
    int[] a3 = {0};
    System.out.println(p.addToArrayForm(a3, 23).toString());
  }
}
