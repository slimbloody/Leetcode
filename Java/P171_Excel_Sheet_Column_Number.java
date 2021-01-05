public class P171_Excel_Sheet_Column_Number {
  public int titleToNumber(String s) {
    return sol1(s);
  }
  
  public int sol1(String s) {
    int res = 0;
    for (int i = 0; i < s.length(); ++i) {
      res = res * 26 + (s.charAt(i) - 'A');
    }
    
    return res;
  }
}
