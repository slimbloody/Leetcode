import java.sql.Time;
import java.util.Map;
import java.util.TreeMap;
import sun.jvm.hotspot.memory.Space;

public class P1122_Relative_Sort_Array {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    return sol1(arr1, arr2);
  }
  
//  Time: O(NlogN)
//  Space: O(N)
  public int[] sol1(int[] arr1, int[] arr2) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (Integer item: arr1) {
      map.put(item, map.getOrDefault(item, 0) + 1);
    }
    
    int i = 0;
    
    for (Integer item: arr2) {
      for (int j = 0; j < map.get(item); ++j) {
        arr1[i++] = item;
      }
      map.remove(item);
    }
    
    for (Integer item : map.keySet()) {
      for (int j = 0; j < map.get(item); ++j) {
        arr1[i++] = item;
      }
    }
    
    return arr1;
  }
  
  //  Time: O(1)
  //  Space: O(1)
  //  arr1.length, arr2.length <= 1000
  //  0 <= arr1[i], arr2[i] <= 1000
  public int[] sol2(int[] arr1, int[] arr2) {
    int[] cnt = new int[1001];
    for (int n: arr1) {
      ++cnt[n];
    }
    int i = 0;
    
    for (int n: arr2) {
      while (cnt[n]-- > 0) {
        arr1[i++] = n;
      }
    }
    
    return arr1;
  }
}
