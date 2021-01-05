import java.util.Arrays;

public class P985_Sum_of_Even_Numbers_After_Queries {
  public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    return sol2(A, queries);
  }
  
  public int[] sol1(int[] A, int[][] queries) {
    int sum = Arrays
        .stream(A)
        .filter(x -> x % 2 == 0)
        .reduce(0, Integer::sum);
    
    int[] res = new int[A.length];
    for (int i = 0; i < queries.length; ++i) {
      int num = queries[i][0];
      int index = queries[i][1];
      
      int replace = A[index] + num;
      if (replace % 2 == 0) {
        if (A[index] % 2 == 0) {
          sum += num;
        }
        else {
          sum += replace;
        }
      }
      else {
        if (A[index] % 2 == 0) {
          sum -= A[index];
        }
      }
      A[index] = replace;
      res[i] = sum;
    }
    
    return res;
  }
  
  public int[] sol2(int[] A, int[][] queries) {
    int sum = Arrays
        .stream(A)
        .filter(x -> x % 2 == 0)
        .reduce(0, Integer::sum);
    
    int[] res = new int[A.length];
    int index = 0;
    for (int[] q: queries) {
      if (A[q[1]] % 2 == 0) {
        sum -= A[q[1]];
      }
      A[q[1]] += q[0];
      if (A[q[1]] % 2 == 0) {
        sum += A[q[1]];
      }
      res[index++] = sum;
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P985_Sum_of_Even_Numbers_After_Queries p = new P985_Sum_of_Even_Numbers_After_Queries();
    int[] A1 = {1,2,3,4};
    int[][] queries1 = {{1,0},{-3,1},{-4,0},{2,3}};
    int[] res1 = {8,6,2,4};
    System.out.println(Arrays.toString(p.sumEvenAfterQueries(A1, queries1)));
    System.out.println(Arrays.equals(p.sumEvenAfterQueries(A1, queries1), res1));
  }
}
