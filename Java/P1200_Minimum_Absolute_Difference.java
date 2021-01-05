import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1200_Minimum_Absolute_Difference {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    return sol1(arr);
  }

  public List<List<Integer>> sol1(int[] arr) {
    Arrays.sort(arr);
    int min = Integer.MAX_VALUE;
    List<List<Integer>> res = new ArrayList();
  
    for (int i = 0; i < arr.length - 1; i++) {
      int diff = arr[i + 1] - arr[i];
      if (diff < min) {
        min = diff;
        res.clear();
        res.add(Arrays.asList(arr[i], arr[i + 1]));
      }
      else if (diff == min) {
        res.add(Arrays.asList(arr[i], arr[i + 1]));
      }
    }
    return res;
  }
}
