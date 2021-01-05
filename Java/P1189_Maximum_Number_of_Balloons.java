import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1189_Maximum_Number_of_Balloons {
  public int maxNumberOfBalloons(String text) {
    return sol1(text);
  }
  
  public int sol1(String text) {
    int[] alphabet = new int['z' - 'a' + 1];
    for (int i = 0; i < alphabet.length; ++i) {
      alphabet[i] = 0;
    }
    for (int i = 0; i < text.length(); ++i) {
      alphabet[text.charAt(i) - 'a'] += 1;
    }
    // b a n
    int min = alphabet['b' - 'a'];
    min = Math.min(min, alphabet['a' - 'a']);
    min = Math.min(min, alphabet['n' - 'a']);
    // l o
    min = Math.min(min, alphabet['l' - 'a'] / 2);
    min = Math.min(min, alphabet['o' - 'a'] / 2);
    return min;
  }
  
  public int sol2(String text) {
    int[] alphabet = new int['z' - 'a' + 1];
    for (int i = 0; i < alphabet.length; ++i) {
      alphabet[i] = 0;
    }
    for (int i = 0; i < text.length(); ++i) {
      alphabet[text.charAt(i) - 'a'] += 1;
    }
    // b a n
    List<Integer> singles = new ArrayList<>();
    singles.add(alphabet['b' - 'a']);
    singles.add(alphabet['a' - 'a']);
    singles.add(alphabet['n' - 'a']);
    Collections.sort(singles);
    
    // l o
    List<Integer> doubles = new ArrayList<>();
    doubles.add(alphabet['l' - 'a']);
    doubles.add(alphabet['o' - 'a']);
    Collections.sort(doubles);
    Integer minSingle = singles.get(0);
    Integer minDouble = doubles.get(0);
    
//    if (minSingle * 2 > minDouble) {
//      return minDouble / 2;
//    }
//    else {
//      return minSingle;
//    }
    // optimize:
    return Math.min(minSingle, minDouble / 2);
  }

}
