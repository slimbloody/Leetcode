public class P806_Number_of_Lines_To_Write_String {
  public int[] numberOfLines(int[] widths, String S) {
    return sol1(widths, S);
  }
  
  public int[] sol1(int[] widths, String S) {
    int row = 1, width = 0;
    for (int i = 0; i < S.length(); ++i) {
      int curWordWidth = widths[S.charAt(i) - 'a'];
      if (width + curWordWidth > 100) {
        ++row;
        width = curWordWidth;
      }
      else {
        width += curWordWidth;
      }
    }
    
    return new int[]{row, width};
  }
}
