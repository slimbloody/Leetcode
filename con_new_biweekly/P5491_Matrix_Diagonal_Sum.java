public class P5491_Matrix_Diagonal_Sum {
  public int diagonalSum(int[][] mat) {
    return sol1(mat);
  }
  
  public int sol1(int[][] mat) {
    int len = mat.length;
    int sum = 0;
    
    for (int i = 0; i < len; ++i) {
      sum += mat[i][i];
    }
  
    for (int i = 0; i < len; ++i) {
      sum += mat[len - 1 - i][i];
    }
    
    
    if ((len & 1) == 1) {
      int mid = len / 2;
      sum -= mat[mid][mid];
    }
    
    return sum;
  }
  
  public static void main(String[] args) {
    P5491_Matrix_Diagonal_Sum p = new P5491_Matrix_Diagonal_Sum();
    int[][] m1 = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
    System.out.println(p.diagonalSum(m1));
  
    int[][] m2 = new int[][]{{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
    System.out.println(p.diagonalSum(m2));
  
    int[][] m3 = new int[][]{{5}};
    System.out.println(p.diagonalSum(m3));
  }
}
