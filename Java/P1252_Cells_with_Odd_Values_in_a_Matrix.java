import java.util.Arrays;
import java.util.BitSet;

public class P1252_Cells_with_Odd_Values_in_a_Matrix {
  public int oddCells(int n, int m, int[][] indices) {
    return sol1(n, m, indices);
  }
  
  // L = indices.length.
  // Time: O(m * n + L), space: O(m + n)
  public int sol1(int n, int m, int[][] indices) {
    int res = 0;
    boolean[] oddRows = new boolean[n], oddCols = new boolean[m];
    
    for (int[] idx: indices) {
      oddRows[idx[0]] ^= true;
      oddCols[idx[1]] ^= true;
    }
  
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        res += (oddRows[i] ^ oddCols[j]) ? 1 : 0;
      }
    }
    
    return res;
  }
  
  //  O(m * n + L), space: O(m + n)
  /*
  Count the rows and columns that appear odd times;
  Compute the number of cells in aforementioned rows and columns respectively, then both deduct the cells located on odd rows and odd columns (they become evens, because odd + odd results even).
  Note: Easier alternative way for 2 is odd_cols * even_rows + even_cols * odd_rows -- credit to @lenchen1112.
   */
  public int sol2(int n, int m, int[][] indices) {
    int res = 0;
    boolean[] oddRows = new boolean[n], oddCols = new boolean[m];
    int cntRow = 0, cntCol = 0;
    
    for (int[] idx: indices) {
      oddRows[idx[0]] ^= true;
      oddCols[idx[1]] ^= true;
    }
    
    for (boolean r: oddRows) {
      cntRow += r ? 1 : 0;
    }
  
    for (boolean c: oddCols) {
      cntCol += c ? 1 : 0;
    }
  
    /*
    rr * m代表行变动而导致的变动格子数；
    cc * n代表列变动导致的格子变动数；
    rr * cc 代表因为行列都在此变动而导致变回去的格子数，这些格子被数了两遍，而实际上他们都是偶数，所以要乘以二。
     */
    return m * cntRow + n * cntCol - 2 * cntRow * cntCol;
    // return (m - cntCol) * cntRow + (n - cntRow) * cntCol;
  }
  
  public int sol3(int n, int m, int[][] indices) {
    boolean[] oddRows = new boolean[n], oddCols = new boolean[m];
    int cntRow = 0, cntCol = 0;
    
    for (int[] idx: indices) {
      oddRows[idx[0]] ^= true;
      oddCols[idx[1]] ^= true;
      cntRow += oddRows[idx[0]] ? 1 : -1;
      cntCol += oddCols[idx[1]] ? 1 : -1;
    }
    
    return m * cntRow + n * cntCol - 2 * cntRow * cntCol;
    // return (m - cntCol) * cntRow + (n - cntRow) * cntCol;
  }
  
  // BitSet
  public int sol4(int n, int m, int[][] indices) {
    BitSet oddRows = new BitSet(n), oddCols = new BitSet(m);
    int cntRow = 0, cntCol = 0;
    
    for (int[] idx: indices) {
      oddRows.flip(idx[0]);
      oddCols.flip(idx[1]);
      
      cntRow += oddRows.get(idx[0]) ? 1 : -1;
      cntCol += oddCols.get(idx[1]) ? 1 : -1;
    }
  
    return m * cntRow + n * cntCol - 2 * cntRow * cntCol;
    // return (m - cntCol) * cntRow + (n - cntRow) * cntCol;
  }
  
  public static void main(String[] args) {
    P1252_Cells_with_Odd_Values_in_a_Matrix p = new P1252_Cells_with_Odd_Values_in_a_Matrix();
    int[][] a1 = new int[][]{{0, 1}, {1, 1, }};
    System.out.println(p.sol1(2, 3, a1));
  }
}
