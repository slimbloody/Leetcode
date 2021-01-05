import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P500_Keyboard_Row {
  public String[] findWords(String[] words) {
    return sol1(words);
  }
  
  public String[] sol1(String[] words) {
    List<String> convertRes = new ArrayList<>();
    String row1 = "qwertyuiop";
    String row2 = "asdfghjkl";
    String row3 = "zxcvbnm";
  
    Set<Integer> set1 = row1
        .chars()
        .boxed()
        .collect(Collectors.toSet());
  
    Set<Integer> set2 = row2
        .chars()
        .boxed()
        .collect(Collectors.toSet());
  
    Set<Integer> set3 = row3
        .chars()
        .boxed()
        .collect(Collectors.toSet());
    
    for (String word: words) {
      Set<Integer> temp = word
          .toLowerCase()
          .chars()
          .boxed()
          .collect(Collectors.toSet());
  
      if (set1.containsAll(temp)
          || set2.containsAll(temp)
          || set3.containsAll(temp)) {
        convertRes.add(word);
      }
    }
    
    String[] res = new String[convertRes.size()];
    convertRes.toArray(res);
    
    return res;
  }
  
  public String[] sol2(String[] words) {
    return Stream
        .of(words)
        .filter(
            s -> s
                .toLowerCase()
                .matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")
        )
        .toArray(String[]::new);
  }
  
  public static void main(String[] args) {
    P500_Keyboard_Row p = new P500_Keyboard_Row();
    String[] s1 = new String[]{"Hello","Alaska","Dad","Peace"};
    System.out.println(Arrays.toString(p.findWords(s1)));
  }
}
