public class P977_Squares_of_a_Sorted_Array {
  public int[] sortedSquares(int[] A) {
    return sol1(A);
  }
  
  public int[] sol1(int[] A) {
    int i = 0, j = A.length - 1;
    int[] res = new int[A.length];
    
    for (int k = A.length - 1; k >= 0; --k) {
      if (Math.abs(A[i]) > Math.abs(A[j])) {
        res[k] = A[i] * A[i];
        ++i;
      }
      else {
        res[k] = A[j] * A[j];
        --j;
      }
    }
    
    return res;
  }
}
