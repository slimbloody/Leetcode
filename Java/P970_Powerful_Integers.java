import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class P970_Powerful_Integers {
  public List<Integer> powerfulIntegers(int x, int y, int bound) {
    return sol1(x, y, bound);
  }
  
  public List<Integer> sol1(int x, int y, int bound) {
    Set<Integer> res = new HashSet<>();
    for (int a = 1; a < bound; a *= x) {
      for (int b = 1; a + b <= bound; b *= y) {
        res.add(a + b);
        if (y == 1) {
          break;
        }
      }
      if (x == 1) {
        break;
      }
    }
    return new ArrayList<>(res);
  }
  
  public static void main(String[] args) {
    P970_Powerful_Integers p = new P970_Powerful_Integers();
    System.out.println(
        Arrays.toString(p.powerfulIntegers(2, 3, 10).toArray())
    );
  }
}
