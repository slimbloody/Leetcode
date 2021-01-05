import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P824_Goat_Latin {
  public String toGoatLatin(String S) {
    return sol1(S);
  }
  
  public String sol1(String S) {
    Set<Character> vowels = new HashSet<>(
      Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    );
    
    String res = "";
    int i = 1;
    for (String s: S.split(" ")) {
      res += ' '
        + (vowels.contains(s.charAt(0)) ? s : s.substring(1) + s.charAt(0))
        + "ma";
      for (int j = 0; j < i; ++j) {
        res += "a";
      }
      ++i;
    }
    
    return res.substring(1);
  }
}
