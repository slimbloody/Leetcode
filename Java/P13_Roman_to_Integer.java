import java.util.HashMap;
import java.util.Map;

public class P13_Roman_to_Integer {
  public int romanToInt(String s) {
    return sol1(s);
  }
  
  public int sol1(String s) {
    Map<Character, Integer> roman = new HashMap<Character, Integer>() {{
      put('I', 1);
      put('V', 5);
      put('X', 10);
      put('L', 50);
      put('C', 100);
      put('D', 500);
      put('M', 1000);
    }};
    
    int res = 0;
    for (int i = 0; i < s.length() - 1; ++i) {
      if (roman.get(s.charAt(i)) < roman.get((s.charAt(i + 1)))) {
        res -= roman.get(s.charAt(i));
      }
      else {
        res += roman.get(s.charAt(i));
      }
    }
    
    return res + roman.get(s.charAt(s.length() - 1));
  }
  
  public static void main(String[] args) {
  
  }
}

