import java.util.Arrays;

public class P961_N_Repeated_Element_in_Size_2N_Array {
  public int repeatedNTimes(int[] A) {
    return sol1(A);
  }
  
  // 0 边界条件
  public int sol1(int[] A) {
    int[] arr = new int[10000];
    Arrays.fill(arr, 0);
    
    for (int a: A) {
      ++arr[a];
    }
  
    for (int i = 10000 - 1; i >= 0; --i) {
      if (arr[i] * 2 == A.length) {
        return i;
      }
    }
    
    return -1;
  }
  
  // O(N) time O(1) space
  // If not, it must be [x, x, y, z] or [x, y, z, x].
  // We return A[0] for the cases that we miss.
  // O(N) time O(1) space
  public int sol2(int[] A) {
    for (int i = 2; i < A.length; ++i) {
      if (A[i] == A[i - 1] || A[i] == A[i - 2]) {
        return A[i];
      }
    }
    
    return A[0];
  }
  
  public static void main(String[] args) {
    P961_N_Repeated_Element_in_Size_2N_Array p = new P961_N_Repeated_Element_in_Size_2N_Array();
    int[] a1 = {1,2,3,3};
    System.out.println(p.repeatedNTimes(a1));
  }
}
