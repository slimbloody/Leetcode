import java.util.HashMap;
import java.util.Map;
import javafx.scene.transform.MatrixType;
import javax.xml.stream.FactoryConfigurationError;

public class P766_Toeplitz_Matrix {
  public boolean isToeplitzMatrix(int[][] matrix) {
    return sol1(matrix);
  }
  
  public boolean sol1(int[][] matrix) {
    for (int i = 0; i < matrix.length - 1; ++i) {
      for (int j = 0; j < matrix[0].length - 1; ++j) {
        if (matrix[i][j] != matrix[i + 1][j + 1]) {
          return false;
        }
      }
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    P766_Toeplitz_Matrix p = new P766_Toeplitz_Matrix();
    int[][] a1 = {
        {1,2,3,4},
        {5,1,2,3},
        {9,5,1,2}
    };
    System.out.println(p.isToeplitzMatrix(a1));
  
    int[][] a2 = {
        {1,2},
        {2,2},
    };
    System.out.println(p.isToeplitzMatrix(a2));
  }
}
