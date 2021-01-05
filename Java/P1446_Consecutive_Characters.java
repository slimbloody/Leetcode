public class P1446_Consecutive_Characters {
  public int maxPower(String s) {
    return sol1(s);
  }
  
  public int sol1(String s) {
    int index = 0;
    int res = 0;
    
    while (index < s.length()) {
      int count = 0;
      while ((index + count < s.length())
          && s.charAt(index) == s.charAt(index + count)) {
        ++count;
      }
      
      res = res < count ? count : res;
      index += count;
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P1446_Consecutive_Characters p = new P1446_Consecutive_Characters();
    System.out.println(p.maxPower("leetcode"));
  }
}
