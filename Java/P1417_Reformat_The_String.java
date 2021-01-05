import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class P1417_Reformat_The_String {
  public String reformat(String s) {
    return sol1(s);
  }
  
  // use i = 0, j = 1, i += 2, j += 2 to accelerate
  
  public String sol1(String s) {
    char[] array = s.toCharArray();
    List<Character> alpha = new ArrayList<>();
    List<Character> numeric = new ArrayList<>();
    List<Character> resList = new ArrayList<>();
    List<Character> l1, l2;
    
    for (int i = 0; i < s.length(); ++i) {
      if (Character.isDigit(array[i])) {
        numeric.add(array[i]);
      }
      else if (Character.isAlphabetic(array[i])) {
        alpha.add(array[i]);
      }
    }
  
    if (alpha.size() > numeric.size()) {
      l1 = alpha;
      l2 = numeric;
    }
    else {
      l1 = numeric;
      l2 = alpha;
    }
    
    if (l1.size() - l2.size() > 1) {
      return "";
    }
    else {
      Iterator iter1 = l1.iterator();
      Iterator iter2 = l2.iterator();
      
      while (iter1.hasNext() || iter2.hasNext()) {
        if (iter1.hasNext()) {
          resList.add((Character) iter1.next());
        }
        if (iter2.hasNext()) {
          resList.add((Character) iter2.next());
        }
      }
      
      return resList
          .stream()
          .map(String::valueOf)
          .collect(Collectors.joining());
    }
  }
}
