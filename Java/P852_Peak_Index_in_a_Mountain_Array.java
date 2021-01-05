public class P852_Peak_Index_in_a_Mountain_Array {
  public int peakIndexInMountainArray(int[] A) {
    return sol1(A);
  }
  
  public int sol1(int[] A) {
    for (int i = 1; i < A.length - 1; ++i) {
      if (A[i] > A[i + 1]) {
        return i;
      }
    }
    
    return -1;
  }
  
  
  // log(n) binary search
  public int sol2(int[] A) {
    int low = 0, high = A.length - 1;
    
    while (low < high) {
      int mid = (low + high) / 2;
      
      if (A[mid] < A[mid + 1]) {
        low = mid + 1;
      }
      else if (A[mid - 1] > A[mid]) {
        high = mid;
      }
      else {
        return mid;
      }
    }
    
    return -1;
  }
}
