import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class P888_Fair_Candy_Swap {
  public int[] fairCandySwap(int[] A, int[] B) {
    return sol1(A, B);
  }
  
  public int[] sol1(int[] A, int[] B) {
    int aSum = Arrays.stream(A).sum();
    int bSum = Arrays.stream(B).sum();
    int diff = (bSum - aSum) / 2;
    int[] res = new int[2];
    
    Set<Integer> bSet = Arrays.stream(B).boxed().collect(Collectors.toSet());
    
    for (int num: A) {
      if (bSet.contains(num + diff)) {
        res[0] = num;
        res[1] = num + diff;
        break;
      }
    }
    
    return res;
  }
}
