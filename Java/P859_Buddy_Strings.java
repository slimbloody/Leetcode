import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P859_Buddy_Strings {
  public boolean buddyStrings(String A, String B) {
    return sol1(A, B);
  }
  
  public boolean sol1(String A, String B) {
    List<Integer> l = new ArrayList<>();
    
    if (A.length() != B.length()) {
      return false;
    }
  
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < A.length(); ++i) {
      set.add(A.charAt(i));
      if (A.charAt(i) != B.charAt(i)) {
        l.add(i);
      }
    }
    if (l.size() == 0) {
      if (set.size() < A.length()) {
        return true;
      }
      else {
        return false;
      }
    }
    
    return
      l.size() == 2 &&
      A.charAt(l.get(0)) == B.charAt(l.get(1)) &&
      A.charAt(l.get(1)) == B.charAt(l.get(0));
  }
  
  public static void main(String[] args) {
    P859_Buddy_Strings p = new P859_Buddy_Strings();
    String a1 = "ab"; String b1 = "ab";
    System.out.println(p.buddyStrings(a1, b1) == false);
    String a2 = "abcd"; String b2 = "acbd";
    System.out.println(p.buddyStrings(a2, b2) == true);
    String a3 = "abcde"; String b3 = "abced";
    System.out.println(p.buddyStrings(a3, b3) == true);
    String a4 = "abcde"; String b4 = "bacde";
    System.out.println(p.buddyStrings(a4, b4) == true);
    String a5 = "abcde"; String b5 = "bacdf";
    System.out.println(p.buddyStrings(a5, b5) == false);
    String a6 = "abcd"; String b6 = "badc";
    System.out.println(p.buddyStrings(a6, b6) == false);
    String a7 = "abcde"; String b7 = "badcf";
    System.out.println(p.buddyStrings(a7, b7) == false);
    String a8 = "aa"; String b8 = "aa";
    System.out.println(p.buddyStrings(a8, b8) == true);
  }
}

