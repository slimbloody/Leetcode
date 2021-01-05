public class P896_Monotonic_Array {
  public boolean isMonotonic(int[] A) {
    return sol1(A);
  }
  
  // optimize: one pass
  public boolean sol1(int[] A) {
    boolean isIncr = true, isDecr = true;
    
    for (int i = 1; i < A.length; ++i) {
      isIncr &= A[i - 1] <= A[i];
      isDecr &= A[i - 1] >= A[i];
    }
    
    return isIncr || isDecr;
  }
  
  // two pass
  public boolean sol2(int[] A) {
    int[] diff = new int[A.length - 1];
    for (int i = 1; i < A.length; ++i) {
      diff[i - 1] = A[i] - A[i - 1];
    }
    boolean isIncr = true;
    for (int i = 0; i < diff.length; ++i) {
      if (diff[i] < 0) {
        isIncr = false;
        break;
      }
    }
    boolean isDecr = true;
    for (int i = 0; i < diff.length; ++i) {
      if (diff[i] > 0) {
        isDecr = false;
        break;
      }
    }
    
    return (isIncr || isDecr);
  }
}
