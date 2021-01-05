public class P1309_Decrypt_String_from_Alphabet_to_Integer_Mapping {
  public String freqAlphabets(String s) {
    return sol1(s);
  }
  
  public String sol1(String s) {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    StringBuilder sb = new StringBuilder();
    int i = s.length() - 1;
    
    int val = 0;
    while (i >= 0) {
      System.out.println("curChar: " + s.charAt(i));
      if (s.charAt(i) == '#') {
        System.out.println("#: " + s.substring(i - 2, i));
        val = Integer.valueOf(s.substring(i - 2, i));
        i -= 3;
      }
      else {
        val = Integer.valueOf(s.substring(i, i + 1));
        System.out.println("single: " + val);
        --i;
      }
      System.out.println(val);
      sb.append(alphabet.charAt(val - 1));
    }
    
    return sb.reverse().toString();
  }
  
  // todo:
  // public String sol2(String s) {
  //   def freqAlphabets(self, s):
  //   return ''.join(chr(int(i[:2]) + 96) for i in re.findall(r'\d\d#|\d', s))
  // }
  
  public static void main(String[] args) {
    P1309_Decrypt_String_from_Alphabet_to_Integer_Mapping p = new P1309_Decrypt_String_from_Alphabet_to_Integer_Mapping();
    System.out.println(p.freqAlphabets("10#11#12"));
  }
  
}
