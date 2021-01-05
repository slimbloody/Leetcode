public class P392_Is_Subsequence {
  public boolean isSubsequence(String s, String t) {
    return sol1(s, t);
  }
  
  public boolean sol1(String s, String t) {
    int sIndex = 0, tIndex = 0;
    
    while (sIndex != s.length() && tIndex != t.length()) {
      if (s.charAt(sIndex) == t.charAt(tIndex)) {
        ++sIndex;
      }
      ++tIndex;
    }
    
    return sIndex == s.length();
  }
  
  public static void main(String[] args) {
    P392_Is_Subsequence p = new P392_Is_Subsequence();
    System.out.println(p.isSubsequence("abc", "ahbgdc"));
    System.out.println(p.isSubsequence("axc", "ahbgdc"));
  }
}
