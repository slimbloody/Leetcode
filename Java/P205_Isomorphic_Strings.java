import java.util.HashMap;
import java.util.Map;

public class P205_Isomorphic_Strings {
  public boolean isIsomorphic(String s, String t) {
    return sol1(s, t);
  }
  
  public boolean sol1(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    Map<Character, Boolean> isUsed = new HashMap<>();
    
    for (int i = 0; i < s.length(); ++i) {
      Character key = s.charAt(i);
      Character value = map.get(key);
      
      if (value == null) {
        value = t.charAt(i);
        if (!isUsed.containsKey(value)) {
          isUsed.put(value, true);
        }
        else {
          return false;
        }
        map.put(key, value);
      }
      else {
        if (value != t.charAt(i)) {
          return false;
        }
      }
    }
    
    return true;
  }
  
  
  // ascii 一共 256个, * 2
  public boolean sol2(String s, String t) {
    int[] m = new int[512];
    for (int i = 0; i < s.length(); ++i) {
      if (m[s.charAt(i)] != m[t.charAt(i) + 256]) {
        return false;
      }
      
      m[s.charAt(i)] = i + 1;
      m[t.charAt(i) + 256] = i + 1;
    }
    
    return true;
  }
  
  /*
  def isIsomorphic(self, s, t):
    return len(set(zip(s, t))) == len(set(s)) and len(set(zip(t, s))) == len(set(t))
  */
  
  public static void main(String[] args) {
    P205_Isomorphic_Strings p = new P205_Isomorphic_Strings();
    System.out.println(p.isIsomorphic("egg", "add") == true);
    System.out.println(p.isIsomorphic("foo", "bar") == false);
    System.out.println(p.isIsomorphic("paper", "title") == true);
    System.out.println(p.isIsomorphic("ab", "aa") == false);
    System.out.println(p.isIsomorphic("13", "42") == true);
  }
}
