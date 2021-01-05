public class P1160_Find_Words_That_Can_Be_Formed_by_Characters {
  public int countCharacters(String[] words, String chars) {
    return sol1(words, chars);
  }
  
  public int sol1(String[] words, String chars) {
    int[] alphabet = new int['z' - 'a' + 1];
    for (int i = 0; i < alphabet.length; ++i) {
      alphabet[i] = 0;
    }
    for (int i = 0; i < chars.length(); ++i) {
      ++alphabet[chars.charAt(i) - 'a'];
    }
  
    int sum = 0;
    for (String temp: words) {
      int[] tempAlphabet = new int['z' - 'a' + 1];
      for (int j = 0; j < temp.length(); ++j) {
        ++tempAlphabet[temp.charAt(j) - 'a'];
      }
      
      boolean flag = true;
      for (int i = 0; i < tempAlphabet.length; ++i) {
        if (tempAlphabet[i] > alphabet[i]) {
          flag = false;
        }
      }
      
      sum += flag ? temp.length() : 0;
    }
    
    return sum;
  }
}
