import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P1408_String_Matching_in_an_Array {
  public List<String> stringMatching(String[] words) {
    return sol1(words);
  }
  
  // todo: optimize: group by
  public List<String> sol1(String[] words) {
    List<String> res = new ArrayList<>();
    Arrays.sort(
        words,
        Comparator
            .comparing(String::length)
            .thenComparing(String::compareTo)
    );
    
    System.out.println(Arrays.toString(words));
    for (int i = 0; i < words.length - 1; ++i) {
      for (int j = i + 1; j < words.length; ++j) {
        if (words[j].contains(words[i])) {
          res.add(words[i]);
          break;
        }
      }
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P1408_String_Matching_in_an_Array p = new P1408_String_Matching_in_an_Array();
    String[] s1 = new String[]{"mass", "as", "hero", "superhero"};
    System.out.println(p.stringMatching(s1).toString());
  
    String[] s2 = new String[]{"leetcode","et","code"};
    System.out.println(p.stringMatching(s2).toString());
  
    String[] s3 = new String[]{"blue","green","bu"};
    System.out.println(p.stringMatching(s3).toString());
  }
}
