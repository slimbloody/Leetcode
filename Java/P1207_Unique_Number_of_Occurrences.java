import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1207_Unique_Number_of_Occurrences {
  public boolean uniqueOccurrences(int[] arr) {
    return so1(arr);
  }
  
  public boolean so1(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int num : arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    Set<Integer> set = new HashSet<>(map.values());
    
    return map.size() == set.size();
  }
}
