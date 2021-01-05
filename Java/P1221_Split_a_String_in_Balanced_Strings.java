public class P1221_Split_a_String_in_Balanced_Strings {
  public int balancedStringSplit(String s) {
    return sol1(s);
  }
  
  public int sol1(String s) {
    int res = 0;
    int temp = 0;
    for (int i = s.length() - 1; i >= 0; --i) {
      if (s.charAt(i) == 'R') {
        ++temp;
      }
      else {
        --temp;
      }
      
      if (temp == 0) {
        ++res;
      }
    }
    
    return res;
  }
}
