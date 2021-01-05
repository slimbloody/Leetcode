public class P680_Valid_Palindrome_II {
  public boolean validPalindrome(String s) {
    return sol1(s);
  }
  
  public boolean sol1(String s) {
    int start = 0, end = s.length() - 1, count = 0;
    
    while (start < end) {
      System.out.printf("start: a[%d]: %c\n", start, s.charAt(start));
      System.out.printf("start + 1: a[%d]: %c\n", start + 1, s.charAt(start + 1));
      System.out.printf("end - 1: a[%d]: %c\n", end - 1, s.charAt(end - 1));
      System.out.printf("end: a[%d]: %c\n", end, s.charAt(end));
      if (s.charAt(start) != s.charAt(end)) {
        if (s.charAt(start + 1) == s.charAt(end)) {
          ++count;
          start += 2;
          --end;
          System.out.println(2);
        }
        else if (s.charAt(start) == s.charAt(end - 1)) {
          ++count;
          ++start;
          end -= 2;
          System.out.println(3);
        }
        else {
          return false;
        }
      }
      else {
        System.out.println(1);
        ++start;
        --end;
      }
      
      if (count > 1) {
        return false;
      }
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    P680_Valid_Palindrome_II p = new P680_Valid_Palindrome_II();
//    String s1 = "abca";
//    System.out.println(p.validPalindrome(s1) == true);
//
//    String s2 = "aefbgha";
//    System.out.println(p.validPalindrome(s2) == false);
//
//    String s3 = "aefgbhia";
//    System.out.println(p.validPalindrome(s3) == false);
//
//    String s4 = "abcba";
//    System.out.println(p.validPalindrome(s4) == true);
//
    String s5 = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
    System.out.println(p.validPalindrome(s5) == true);
  
//    String s6 = "tcaac";
//    System.out.println(p.validPalindrome(s6) == true);

//    String s7 = "ebcbbececabbacecbbcbe";
//    System.out.println(p.validPalindrome(s7) == true);
  }
}
