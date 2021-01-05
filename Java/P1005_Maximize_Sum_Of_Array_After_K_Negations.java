import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P1005_Maximize_Sum_Of_Array_After_K_Negations {
  public int largestSumAfterKNegations(int[] A, int K) {
    return sol1(A, K);
  }
  
  public int sol1(int[] A, int K) {
    Arrays.sort(A);
    for (int i = 0; K > 0 && i < A.length && A[i] < 0; ++i, --K) {
      A[i] = -A[i];
    }
    
    int res = 0, min = Integer.MAX_VALUE;
    
    for (int a : A) {
      res += a;
      min = Math.min(min, a);
    }
    
    return res - (K % 2) * min * 2;
  }
  
  // complicate, dessert
  public int sol2(int[] A, int K) {
    int res = 0;
    List<Integer> negList = new ArrayList<>();
    int minAbsNum = Integer.MAX_VALUE;
    
    for (int i = 0; i < A.length; ++i) {
      res += A[i];
      
      if (Math.abs(A[i]) < minAbsNum) {
        minAbsNum = Math.abs(A[i]);
      }
      
      if (A[i] < 0) {
        negList.add(A[i]);
      }
    }
    Collections.sort(negList);
    if (K > negList.size()) {
      if ((K - negList.size()) % 2 != 0) {
        res -= minAbsNum;
      }
    }
    else {
    }
    
    return res;
  
  }
}
