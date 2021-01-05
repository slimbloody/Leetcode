import java.util.HashSet;
import java.util.Set;

public class P804_Unique_Morse_Code_Words {
  String[]MORSE = {
      ".-","-...","-.-.","-..",".","..-.",
      "--.","....","..",".---","-.-",".-..",
      "--","-.","---",".--.","--.-",".-.",
      "...","-","..-","...-",".--","-..-",
      "-.--","--.."
  };
  
  public int uniqueMorseRepresentations(String[] words) {
    return sol1(words);
  }
  
  public int sol1(String[] words) {
    Set<String> seen = new HashSet();
    for (String word: words) {
      StringBuilder code = new StringBuilder();
      for (char c: word.toCharArray())
        code.append(MORSE[c - 'a']);
      seen.add(code.toString());
    }
  
    return seen.size();
  }
  
  // better potential solution
  // find the some combination of letters
  // then replace the combination
  // eg: "gin" -> "--...-."
  //     "zen" -> "--...-."
  //      gi == ze
  public int sol2(String[] words) {
    return 0;
  }
}
