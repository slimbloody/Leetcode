public class P125_Valid_Palindrome {
  public boolean isPalindrome(String s) {
    return sol1(s);
  }
  
  public boolean sol1(String s) {
    int start = 0, end = s.length() - 1;
    System.out.println(s.length() - 1);
    
    while (start < end) {
      while (!Character.isAlphabetic(s.charAt(start))) {
        ++start;
      }
  
      while (!Character.isAlphabetic(s.charAt(end))) {
        --end;
      }
      System.out.printf("start: a[%d]: %c\n", start, s.charAt(start));
      System.out.printf("end: a[%d]: %c", end, s.charAt(end));
      if (start < end) {
        if (s.charAt(start) != s.charAt(end)) {
          return false;
        }
        
        ++start;
        --end;
      }
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    P125_Valid_Palindrome p = new P125_Valid_Palindrome();
    String s1 = "A man, a plan, a canal: Panama";
    System.out.println(p.isPalindrome(s1) == true);
  }
}
