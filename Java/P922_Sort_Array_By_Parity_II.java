public class P922_Sort_Array_By_Parity_II {
  public int[] sortArrayByParityII(int[] A) {
    return sol1(A);
  }
  
  // two pointer
  public int[] sol1(int[] A) {
    int[] res = new int[A.length];
    int i = 0, j = 1;
    
    for (int k = 0; k < A.length; ++k) {
      if (A[k] % 2 == 0) {
        res[i] = A[k];
        i += 2;
      } else {
        res[j] = A[k];
        j += 2;
      }
    }
    
    return res;
  }
  
  // o(1)
  // 因为一定配对出现, 所以找不配对的, 交换就行, i < n && j < n
  // public int[] sol1(int[] A) {
  // }
}
