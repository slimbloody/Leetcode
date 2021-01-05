public class P6_ZigZag_Conversion {
  public String convert(String s, int numRows) {
    return sol1(s, numRows);
  }
  
  public String sol1(String s, int numRows) {
    int round = numRows * 2 - 2;
    int col = s.length() % round + s.length() / round;
    char[][] maxtrix = new char[numRows][col];
    int r = 0, c = 0;
    boolean isVertical = true;
    
    for (int i = 0; i < s.length(); ++i) {
      if (isVertical) {
        maxtrix[r][c] = s.charAt(i);
        ++r;
      }
      else {
      }
    }
    return "";
  }
  
}
