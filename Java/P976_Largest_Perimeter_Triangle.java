import java.util.Arrays;

public class P976_Largest_Perimeter_Triangle {
  public int largestPerimeter(int[] A) {
    return sol1(A);
  }
  
  public int sol1(int[] A) {
    Arrays.sort(A);
    for (int i = A.length - 1; i >= 2; --i) {
      if (A[i] < (A[i - 1] + A[i - 2])) {
        return A[i] + A[i - 1] + A[i - 2];
      }
    }
    return 0;
  }
}
