import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1380_Lucky_Numbers_in_a_Matrix {
  public List<Integer> luckyNumbers(int[][] matrix) {
    return sol1(matrix);
  }
  
  public List<Integer> sol1(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[] min = new int[m], max = new int[n];
    Arrays.fill(min, Integer.MAX_VALUE);
    Arrays.fill(max, Integer.MIN_VALUE);
    
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        min[i] = Math.min(matrix[i][j], min[i]);
        max[j] = Math.max(matrix[i][j], max[j]);
      }
    }
  
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (min[i] == max[j]) {
          res.add(min[i]);
        }
      }
    }
    
    return res;
  }
  
  // use Set_min, Set_max instead of array
  // public List<Integer> sol2(int[][] matrix) {
  // }
  
  // sol2: distinct num, intersection of min(row) and max(col
  // )
}
