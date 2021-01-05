public class P1351_Count_Negative_Numbers_in_a_Sorted_Matrix {
  public int countNegatives(int[][] grid) {
    return sol1(grid);
  }
  
  public int sol1(int[][] grid) {
    int c = grid[0].length - 1;
    int r = 0;
    int res = 0;
    int count = 0;
  
    while (r < grid.length && c >= 0) {
      System.out.println("r: " + r + " c: " + c);
      if (grid[r][c] < 0) {
        ++count;
        --c;
      }
      else {
        res += count;
        ++r;
      }
    }
  
    System.out.println(res);
    res += (grid.length - r) * grid[0].length;
    
    return res;
  }
}

/*
 4  3  2 -1
 3  2  1 -1
 1  1 -1 -2
-1 -1 -2 -3
 */
// This solution uses the fact that the negative regions
// of the matrix will form a "staircase" shape
