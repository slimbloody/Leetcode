public class P389_Find_the_Difference {
  public char findTheDifference(String s, String t) {
    return sol1(s, t);
  }
  
  public char sol1(String s, String t) {
    char res = 0;
    
    for (int i = 0; i < s.length(); ++i) {
      res ^=  s.charAt(i);
    }
    
    for (int i = 0; i < t.length(); ++i) {
      res ^= t.charAt(i);
    }
  
    return res;
  }
  
  public static void main(String[] args) {
    P389_Find_the_Difference p = new P389_Find_the_Difference();
    System.out.println(p.findTheDifference("abcd", "abcde"));
  }
}
