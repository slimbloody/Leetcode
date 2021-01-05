import java.util.Arrays;

public class P5511_Special_Positions_in_a_Binary_Matrix {
  public int numSpecial(int[][] mat) {
    return sol1(mat);
  }
  
  public int sol1(int[][] mat) {
    int rows = mat.length;
    int cols = mat[0].length;
    int res = 0;
    
    for (int r = 0; r < rows; ++r) {
      for (int c = 0; c < cols; ++c) {
        if (mat[r][c] == 1) {
          res += sol1CheckMatrix(r, c, mat);
        }
      }
    }
    
    return res;
  }
  
  public int sol1CheckMatrix(int r, int c, int[][] mat) {
    for (int[] d: new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}) {
      for (
        int row = r + d[0], col = c + d[1];
        (0 <= row && row <= mat.length - 1)
            && (0 <= col && col <= mat[0].length - 1);
        row += d[0], col += d[1]) {
  
        if (mat[row][col] == 1) {
          return 0;
        }
      }
    }
    
    return 1;
  }
  
  public static void main(String[] args) {
    P5511_Special_Positions_in_a_Binary_Matrix p = new P5511_Special_Positions_in_a_Binary_Matrix();
    int[][]a1 = new int[][]{
        {1,0,0},
        {0,0,1},
        {1,0,0}
    };
    System.out.println(p.sol1(a1));
    
    int[][]a2 = new int[][]{
        {1,0,0},
        {0,1,0},
        {0,0,1}
    };
    System.out.println(p.sol1(a2));

    int[][]a3 = new int[][]{
        {0,0,0,1},
        {1,0,0,0},
        {0,1,1,0},
        {0,0,0,0}
    };
    System.out.println(p.sol1(a3));

    int[][]a4 = new int[][]{
        {0,0,0,0,0},
        {1,0,0,0,0},
        {0,1,0,0,0},
        {0,0,1,0,0},
        {0,0,0,1,1}
    };
    System.out.println(p.sol1(a4));
  }
  
  // todo: remove the checked row and column
}




