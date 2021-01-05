import java.util.HashSet;
import java.util.Set;

public class P1247_Minimum_Swaps_to_Make_Strings_Equal {
  public int minimumSwap(String s1, String s2) {
    return sol1(s1, s2);
  }
  
  public int sol1(String s1, String s2) {
    int xy = 0, yx = 0;
    for (int i = 0; i < s1.length(); ++i) {
      
      if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
        ++xy;
      }
      else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
        ++yx;
      }
    }
  
   int tail = xy % 2 + yx % 2;
    if ((tail & 1) == 1) {
      return -1;
    }
    else {
      return (xy / 2) + (yx / 2) + tail;
    }
  }
  
  public int sol2(String s1, String s2) {
    Set<String> set = new HashSet<>();
    int res = 0;
    
    for (int i = 0; i < s1.length(); ++i) {
      if (s1.charAt(i) != s2.charAt(i)) {
        String pair = s1.charAt(i) + "" + s2.charAt(i);
        set.add(pair);
        
        if (set.contains(pair)) {
          set.remove(pair);
          ++res;
        }
        else {
          set.add(pair);
        }
      }
    }
    
    if (set.size() == 1) {
      return -1;
    }
    else if (set.size() == 2) {
      return res + 2;
    }
    else {
      return res;
    }
  }
  
  public static void main(String[] args) {
    P1247_Minimum_Swaps_to_Make_Strings_Equal p = new P1247_Minimum_Swaps_to_Make_Strings_Equal();
    System.out.println(p.minimumSwap("xx", "yy") == 1);
    System.out.println(p.minimumSwap("xy", "yx") == 2);
    System.out.println(p.minimumSwap("xx", "xy") == -1);
    System.out.println(p.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx") == 4);
  }
}
