import java.util.ArrayList;
import java.util.List;

public class P821_Shortest_Distance_to_a_Character {
  public int[] shortestToChar(String S, char C) {
    return sol1(S, C);
  }
  
  public int[] sol1(String S, char C) {
    int[] res = new int[S.length()];
    List<Integer> indexList = new ArrayList<>();
    
    for (int i = 0; i < S.length(); ++i) {
      if (S.charAt(i) == C) {
        indexList.add(i);
      }
    }
    
    Integer left = null, right = null;
    for (int i = 0; i < indexList.size(); ++i) {
    }
    
    return res;
  }
}
