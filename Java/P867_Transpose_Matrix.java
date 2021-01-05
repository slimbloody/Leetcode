public class P867_Transpose_Matrix {
  public int[][] transpose(int[][] A) {
    return sol1(A);
  }
  
  public int[][] sol1(int[][] A) {
    int [][]B = new int[A[0].length][A.length];
    
    for (int i = 0; i < A.length; ++i) {
      for (int j = 0; j < A[0].length; ++j) {
        B[j][i] = A[i][j];
      }
    }
    
    return B;
  }
}
