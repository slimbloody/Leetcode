public class P1614_Maximum_Nesting_Depth_of_the_Parentheses {
  public int maxDepth(String s) {
    return sol1(s);
  }
  
  public int sol1(String s) {
    int res = 0;
    int temp = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '(') {
        ++temp;
      }
      else if (s.charAt(i) == ')') {
        --temp;
      }
      else {
        continue;
      }
      res = Math.max(res, temp);
    }
    
    return res;
  }
}
