public class P344_Reverse_String {
  public void reverseString(char[] s) {
    sol1(s);
  }
  
  public void sol1(char[] s) {
    for (int i = 0; i < s.length / 2; ++i) {
      char temp = s[i];
      s[i] = s[s.length - 1 - i];
      s[s.length - 1 - i] = temp;
    }
  }
  
  
  // error for what?
  public void sol2(char[] s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length; ++i) {
      sb.append(s[i]);
    }
    s = sb.reverse().toString().toCharArray();
  }
  
  public static void main(String[] args) {
    P344_Reverse_String p = new P344_Reverse_String();
    char[] s = {'1', '2', '3'};
    p.sol1(s);
    System.out.println(s);
  }
}
