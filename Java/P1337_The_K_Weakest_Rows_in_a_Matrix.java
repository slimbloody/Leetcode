import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import javafx.util.Pair;

public class P1337_The_K_Weakest_Rows_in_a_Matrix {
  public int[] kWeakestRows(int[][] mat, int k) {
    return sol2(mat, k);
  }
  
  public int[] sol1(int[][] mat, int k) {
    int[] res = new int[k];
    List<Pair<Integer, Integer>> l = new ArrayList<>();
    for (int i = 0; i < mat.length; ++i) {
      int temp = 0;
      for (int j = 0; j < mat[i].length; ++j) {
        if (mat[i][j] == 0) {
          break;
        }
        else {
          ++temp;
        }
      }
      l.add(new Pair<>(temp, i));
    }
  
    Collections.sort(l, (o1, o2) -> o1.getKey() - o2.getKey());
    for (int i = 0; i < k; ++i) {
      System.out.println(i);
      res[i] = l.get(i).getValue();
    }
    
    return res;
  }
  
  public int[] sol2(int[][] mat, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(
      (a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]
    );
    int[] res = new int[k];
    
    for (int i = 0; i < mat.length; ++i) {
      pq.offer(new int[]{numOnes(mat[i]), i});
      if (pq.size() > k) {
        pq.poll();
      }
    }
    // while (k > 0) {
    //   res[--k] = pq.poll()[1];
    // }
    //
    // System.out.println(pq.size());
    // System.out.println(k - 1);
    for (int i = k - 1; i >= 0; --i) {
      res[i] = pq.poll()[1];
    }
    
    return res;
  }
  
  private int numOnes(int[] row) {
    int low = 0, high = row.length;
    
    while (low < high) {
      int mid = (low + high) / 2;
      
      if (row[mid] == 1) {
         low = mid + 1;
      }
      else {
        high = mid;
      }
    }
    
    return low;
  }
  
  public static void main(String[] args) {
    int a = (0 + 7) / 2;
    System.out.println(a);
  }
}
