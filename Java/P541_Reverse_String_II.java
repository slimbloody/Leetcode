public class P541_Reverse_String_II {
  public String reverseStr(String s, int k) {
    return sol1(s, k);
  }

  public String sol1(String s, int k) {
    int index = 0;
    char[] array = s.toCharArray();
    
    while (index < s.length()) {
      int bound;
      
      if (index + k - 1 < s.length()) {
        bound = index + k - 1;
      }
      else {
        bound = s.length() - 1;
      }
      
      int start = index, end = bound;
      
      while (start < end) {
        char temp = array[start];
        array[start++] = array[end];
        array[end--] = temp;
      }
      
      index += 2 * k;
    }
    
    return new String(array);
  }
  
  public static void main(String[] args) {
    P541_Reverse_String_II p = new P541_Reverse_String_II();
    System.out.println(p.reverseStr("", 0));
    System.out.println(p.reverseStr("", 0).equals(""));
    
    System.out.println(p.reverseStr("123456", 3));
    System.out.println(p.reverseStr("123456", 3).equals("321456"));
  
    System.out.println(p.reverseStr("1234567", 3));
    System.out.println(p.reverseStr("1234567", 3).equals("3216547"));
  
    System.out.println(p.reverseStr("12345678", 3));
    System.out.println(p.reverseStr("12345678", 3).equals("12365487"));
  
    System.out.println(p.reverseStr("123456789", 2));
    System.out.println(p.reverseStr("123456789", 2).equals("213465789"));
  }
}

