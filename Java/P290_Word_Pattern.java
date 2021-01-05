import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P290_Word_Pattern {
  public boolean wordPattern(String pattern, String str) {
    return sol1(pattern, str);
  }
  
  public boolean sol1(String pattern, String str) {
    Map<Character, String> map = new HashMap<>();
    String[] sArr = str.split(" ");
    
    for (int i = 0; i < sArr.length; ++i) {
      char c = pattern.charAt(i);
      String temp = map.getOrDefault(c, null);
      
      if (temp == null) {
        map.put(c, sArr[i]);
      }
      else {
        if (!temp.equals(sArr[i])) {
          return false;
        }
      }
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    P290_Word_Pattern p = new P290_Word_Pattern();
    System.out.println(
        p.wordPattern("abba", "dog cat cat dog") == true
    );
    // edge case
    
    System.out.println(
        p.wordPattern("abba", "dog dog dog dog") == false
    );
  
    System.out.println(
        p.wordPattern("aaaa", "dog cat cat dog") == false
    );
  
    System.out.println(
        p.wordPattern("abba", "dog cat cat fish") == false
    );
  }
}
