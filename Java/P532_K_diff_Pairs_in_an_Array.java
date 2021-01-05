import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P532_K_diff_Pairs_in_an_Array {
  public int findPairs(int[] nums, int k) {
    return sol1(nums, k);
  }
  
  public int sol1(int[] nums, int k) {
    int res = 0;
    
    if (nums == null || nums.length == 0 || k < 0) {
      return res;
    }
    
    Map<Integer, Long> map = Arrays
        .stream(nums)
        .boxed()
        .collect(
            Collectors.groupingBy(Function.identity(), Collectors.counting())
        );
    
    for (Map.Entry<Integer, Long> entry: map.entrySet()) {
      if (k == 0) {
        if (entry.getValue() >= 2) {
          ++res;
        }
      }
      else {
        if (map.containsKey(entry.getKey() + k)) {
          ++res;
        }
      }
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P532_K_diff_Pairs_in_an_Array p = new P532_K_diff_Pairs_in_an_Array();
    int[] a1 = new int[]{3, 1, 4, 1, 5};
    System.out.println(p.findPairs(a1, 2) == 2);
  }
}
