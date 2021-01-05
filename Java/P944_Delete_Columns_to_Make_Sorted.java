public class P944_Delete_Columns_to_Make_Sorted {
  public int minDeletionSize(String[] A) {
    return sol1(A);
  }
  
  public int sol1(String[] A) {
    int len = A[0].length();
    int res = 0;
    
    for (int c = 0; c < len; ++c) {
      for (int r = 0; r < A.length - 1; ++r) {
        if (A[r].charAt(c) > A[r + 1].charAt(c)) {
          ++res;
          break;
        }
      }
    }
    
    return res;
  }
}
