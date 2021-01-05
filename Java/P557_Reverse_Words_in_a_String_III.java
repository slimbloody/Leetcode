public class P557_Reverse_Words_in_a_String_III {
  public String reverseWords(String s) {
    return sol1(s);
  }
  
  public String sol1(String s) {
    String[] sArr = s.split(" ");
    StringBuilder sBuilder = new StringBuilder();
    for (int i = 0; i < sArr.length; ++i) {
      sArr[i] =  new StringBuilder(sArr[i]).reverse().toString();
    }
    return String.join(" ", sArr);
  }
}
