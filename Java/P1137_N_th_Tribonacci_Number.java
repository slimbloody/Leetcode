public class P1137_N_th_Tribonacci_Number {
  public int tribonacci(int n) {
    return sol2(n);
  }
  
  public int sol1(int n) {
    int[] arr = new int[38];
    arr[0] = 0;
    arr[1] = 1;
    arr[2] = 1;
    
    for (int i = 3; i <= n; ++i) {
      arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
    }
    
    return arr[n];
  }
  
  // O(k^3log(n)) Solution (k=3)
  // 矩阵快速幂
  // 矩阵k维: 复杂度就是k^3次,
  // log(n):
  // 2 ^ 32 = 2^16 * 2^16
  // 2 ^ 16 = 2^8 * 2^8
  // 2 ^  8 = 2^4 * 2^4
  // 2 ^  4 = 2^2 * 2^2
  
  /*
  | f(n)   |     | 1 1 1 |     | f(n-1) |
  | f(n-1) |  =  | 1 0 0 |  *  | f(n-2) |
  | f(n-2) |     | 0 1 0 |     | f(n-3) |
  
  
  
  | f(n)   |     | 1 1 1 |^(n-2)     | f(2) |
  | f(n-1) |  =  | 1 0 0 |       *   | f(1) |
  | f(n-2) |     | 0 1 0 |           | f(0) |
   */
  
  public int sol2(int n) {
    if (n == 0) {
      return 0;
    }
    else if (n == 1 || n == 2) {
      return 1;
    }
    
    int f_0 = 0, f_1 = 1, f_2 = 1;
    
    int[][] matrix = new int[][]{
      {1, 1, 1},
      {1, 0, 0},
      {0, 1, 0}
    };
    int[][] res = sol2MatrixPow(matrix, n - 2);
    
    return sol2MatrixMultiply(res, new int[][]{{f_2}, {f_1}, {f_0}})[0][0];
  }
  
  public int[][] sol2MatrixMultiply(int[][] matrix1, int[][] matrix2) {
    int[][] res = new int[matrix1.length][matrix2[0].length];
    for (int i = 0; i < matrix1.length; ++i) {
      for (int k = 0; k < matrix2.length; ++k) {
        for (int j = 0; j < matrix2[0].length; ++j) {
          res[i][j] += (matrix1[i][k] * matrix2[k][j]);
        }
      }
    }
    
    return res;
  }
  
  public int[][] sol2MatrixPow(int[][] matrix, int pow) {
    if (pow == 0) {
      for (int i = 0; i < matrix.length; ++i) {
        for (int j = 0; j < matrix[0].length; ++j) {
          matrix[i][j] = 0;
        }
      }
    }
    else if (pow == 1) {
      return matrix;
    }
    
    int[][] newMatrix = sol2MatrixPow(matrix, pow / 2);
    newMatrix = sol2MatrixMultiply(newMatrix, newMatrix);
  
    if (pow % 2 == 1) {
      return sol2MatrixMultiply(newMatrix, matrix);
    }
    
    return newMatrix;
  }
}
