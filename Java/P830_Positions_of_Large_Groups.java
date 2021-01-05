import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P830_Positions_of_Large_Groups {
  public List<List<Integer>> largeGroupPositions(String S) {
    return sol1(S);
  }
  
  public List<List<Integer>> sol1(String S) {
    List<List<Integer>> res = new ArrayList<>();
    int i = 0;
    
    for (int j = 0; j < S.length(); ++j) {
      if (j == S.length() - 1 || S.charAt(j) != S.charAt(j + 1)) {
        if (j - i + 1 >= 3) {
          res.add(Arrays.asList(i, j));
        }
        i = j + 1;
      }
    }
  
    return res;
  }
  
  public List<List<Integer>> sol2(String S) {
    List<List<Integer>> res = new ArrayList<>();
    int start = 0, end;
    
    while (start < S.length()) {
      for (end = start - 1; end < S.length() - 1; ++end) {
        if (S.charAt(start) != S.charAt(end + 1)) {
          break;
        }
      }
  
      if (end - start >= 2) {
        res.add(Arrays.asList(start, end));
      }
      
      start = end + 1;
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P830_Positions_of_Large_Groups p = new P830_Positions_of_Large_Groups();
    System.out.println(p.largeGroupPositions("abbxxxxzzy"));
    System.out.println(p.largeGroupPositions("abc"));
  }
}
