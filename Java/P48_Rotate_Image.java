import java.util.Arrays;

public class P48_Rotate_Image {
  public void rotate(int[][] matrix) {
    sol2(matrix);
  }
  
  /*
   * clockwise rotate
   * first reverse up to down, then swap the symmetry
   * 1 2 3     7 8 9     7 4 1
   * 4 5 6  => 4 5 6  => 8 5 2
   * 7 8 9     1 2 3     9 6 3
   */
  public void sol1(int[][] matrix) {
    int n = matrix.length, temp;
    int[] tempArr;
    for (int i = 0; i < n / 2; ++i) {
      tempArr = matrix[i];
      matrix[i] = matrix[n - i - 1];
      matrix[n - i - 1] = tempArr;
    }
    
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }
  
  /*
   * anticlockwise rotate
   * first reverse left to right, then swap the symmetry
   * 1 2 3     3 2 1     3 6 9
   * 4 5 6  => 6 5 4  => 2 5 8
   * 7 8 9     9 8 7     1 4 7
   */
  public void sol11(int[][] matrix) {
    int n = matrix.length, temp;
  
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n / 2; ++j) {
        temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = temp;
      }
    }
    System.out.println(Arrays.deepToString(matrix));
  
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    System.out.println(Arrays.deepToString(matrix));
  }
  
  public void sol2(int[][] matrix) {
    int n = matrix.length, a = 0, b = n - 1;
    int temp;
    
    while (a < b) {
      for (int i = 0; i < b - a; ++i) {
        // swap(matrix[a][a+i], matrix[a+i][b]);
        temp = matrix[a][a + i];
        matrix[a][a + i] = matrix[a + i][b];
        matrix[a + i][b] = temp;
        
        // swap(matrix[a][a+i], matrix[b][b-i]);
        temp = matrix[a][a + i];
        matrix[a][a + i] = matrix[b][b - i];
        matrix[b][b - i] = temp;
        
        // swap(matrix[a][a+i], matrix[b-i][a]);
        temp = matrix[a][a + i];
        matrix[a][a + i] = matrix[b - i][a];
        matrix[b - i][a] = temp;
      }
      
      ++a;
      --b;
    }
  }
  
  // same as sol3
  public void sol3(int[][] matrix) {
    int n = matrix.length, temp;
    for(int i = 0; i < n / 2; i++)
      for(int j = i; j < n - i - 1; j++) {
        temp = matrix[i][j];
        matrix[i][j] = matrix[n - j - 1][i];
        matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
        matrix[j][n - i - 1] = temp;
      }
  }
  
  public void test() {
    int[][] a = {{1, 2}, {3, 4}};
    int[] temp;
    temp = a[0];
    a[0] = a[1];
    a[1] = temp;
    System.out.println(Arrays.toString(a[0]));
    System.out.println(Arrays.toString(a[1]));
  }
  
  public static void main(String[] args) {
  }
}
