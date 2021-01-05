import java.util.Set;
import java.util.stream.Collectors;

public class P771_Jewels_and_Stones {
  public int numJewelsInStones(String J, String S) {
    return sol1(J, S);
  }
  
  public int sol1(String J, String S) {
    Set<Integer> set = J.chars().boxed().collect(Collectors.toSet());
    return (int) S
        .chars()
        .boxed()
        .filter(set::contains)
        .count();
  }
  
  public static void main(String[] args) {
    P771_Jewels_and_Stones p = new P771_Jewels_and_Stones();
    System.out.println(p.numJewelsInStones("aA", "aAAbbbb"));
    System.out.println(p.numJewelsInStones("z", "ZZ"));
  }
}
