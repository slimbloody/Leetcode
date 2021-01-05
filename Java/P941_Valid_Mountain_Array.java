public class P941_Valid_Mountain_Array {
  public boolean validMountainArray(int[] A) {
    return sol1(A);
  }
  
  // two pointer
  public boolean sol1(int[] A) {
    int n = A.length, i = 0, j = n - 1;
    while (i + 1 < n && A[i] < A[i + 1]) {
      ++i;
    }
    while (j > 0 && A[j - 1] > A[j]) {
      --j;
    }
    return i > 0 && i == j && j < n - 1;
  }
  
  public boolean sol2(int[] A) {
    int N = A.length;
    int i = 0;
  
    // walk up
    while (i + 1 < N && A[i] < A[i + 1]) {
      ++i;
    }
  
    // peak can't be first or last
    if (i == 0 || i == N - 1) {
      return false;
    }
  
    // walk down
    while (i + 1 < N && A[i] > A[i + 1]) {
      ++i;
    }
    
    return i == N - 1;
  }
  
  public boolean sol3(int[] A) {
    int previous = Integer.MIN_VALUE;
    int pivot = Integer.MIN_VALUE;
    int i = 0;
    for (; i < A.length; ++i) {
      if (A[i] > previous) {
        if (previous != Integer.MIN_VALUE) {
          pivot = A[i];
        }
        previous = A[i];
      }
      else {
        break;
      }
    }
    
    if (i > A.length - 1) {
      return false;
    }
  
    for (; i < A.length; ++i) {
      if (A[i] < previous) {
        previous = A[i];
      }
      else {
        return false;
      }
    }
    
    return pivot != Integer.MIN_VALUE;
  }
}
