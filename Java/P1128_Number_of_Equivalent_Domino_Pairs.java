import java.util.HashMap;
import javafx.util.Pair;

public class P1128_Number_of_Equivalent_Domino_Pairs {
  public int numEquivDominoPairs(int[][] dominoes) {
    return sol1(dominoes);
  }
  
  // prove: 10 * a + b == 10 * c + d
  // ==> a == c && b == d
  public int sol1(int[][] dominoes) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int[] dominoe : dominoes) {
      Integer temp = 10 * Math.min(dominoe[0], dominoe[1]) +
          Math.max(dominoe[0], dominoe[1]);
      map.put(temp, map.getOrDefault(temp, 0) + 1);
    }
    
    return map
        .values()
        .stream()
        .filter(s -> s > 1)
        .reduce(0, (total, s) -> total + s * (s - 1) / 2);
  }
}
