public class P908_Smallest_Range_I {
  public int smallestRangeI(int[] A, int K) {
    return sol1(A, K);
  }
  
  public int sol1(int[] A, int K) {
    int min = A[0], max = A[0];
    for (int num: A) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }
    return Math.max(0, max - min - 2 * K);
  }
}
