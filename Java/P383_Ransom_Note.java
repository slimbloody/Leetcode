import java.util.HashMap;
import java.util.Map;

public class P383_Ransom_Note {
  public boolean canConstruct(String ransomNote, String magazine) {
    return sol1(ransomNote, magazine);
  }
  
  // better
  public boolean sol2(String ransomNote, String magazine) {
    int[] table = new int[26];
    for (char c : magazine.toCharArray()) {
      ++table[c - 'a'];
    }
    for (char c : ransomNote.toCharArray()) {
      if (--table[c - 'a'] < 0) {
        return false;
      }
    }
    
    return true;
  }
  
  public boolean sol1(String ransomNote, String magazine) {
    Map<Character, Integer> ran = getMap(ransomNote);
    Map<Character, Integer> mag = getMap(magazine);
    
    for (Character c: ran.keySet()) {
      if (ran.get(c) > mag.getOrDefault(c, 0)) {
        return false;
      }
    }
    
    return true;
  }
  
  public Map<Character, Integer> getMap(String s) {
    char[] sArr =  s.toCharArray();
     Map<Character, Integer> map = new HashMap<>();
     
     for (int i = 0; i < s.length(); ++i) {
       map.put(sArr[i], map.getOrDefault(sArr[i], 0) + 1);
     }
     
     return map;
  }
  
  public static void main(String[] args) {
    P383_Ransom_Note p = new P383_Ransom_Note();
    System.out.println(p.canConstruct("a", "b") == false);
    System.out.println(p.canConstruct("aa", "ab") == false);
    System.out.println(p.canConstruct("aa", "aab") == true);
  }
}
