public class P242_Valid_Anagram {
  public boolean isAnagram(String s, String t) {
    return sol1(s, t);
  }
  
  public boolean sol1(String s, String t) {
    int[] alphabet = new int[26];
    for (int i = 0; i < s.length(); i++) {
      ++alphabet[s.charAt(i) - 'a'];
    }
    for (int i = 0; i < t.length(); i++) {
      --alphabet[t.charAt(i) - 'a'];
    }
    for (int i : alphabet) {
      if (i != 0) {
        return false;
      }
    }
  
    return true;
  }
}

